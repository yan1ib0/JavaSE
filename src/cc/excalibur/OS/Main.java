package cc.excalibur.OS;


import java.io.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Administrator
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    //存放run信息
    static HashMap<String, List<Run>> info = new HashMap<>();
    /*
     *   因为一个文件中io 不好多次操作  所以将programs和run文件读入内存 但是以下属性 模拟情况为外存
     *
     * */
    //存程序块   模拟外存
    static HashMap<String, HashMap<String, Float>> programs = new HashMap<>();

    /*
     *
     * 以下是模拟内存中的数据
     *
     * */
    //当前运行线程
    static PCB n = null;
    //存放线程信息  io直接加载到内存  就绪队列

    static Queue<PCB> queue = new LinkedList<>();
    static Queue<PCB> readyQueue = new LinkedList<>();
    static Queue<PCB> blockQueue = new LinkedList<>();
    //运行结果
    static List<Result> endQueue = new LinkedList<>();
    //内存中的页面  每次先访问这里  如果缺页  再从模拟外存中读取
    static Deque<Page> memeryPages = new LinkedList<>();  //内存中存在的页面队列
    static int maxpageNum = 0;
    //运行时间
    static int runTime = 0;
    static int printtime = 0;

    public static void main(String[] args) throws IOException {
        //读取文件到内存
        readFile();

        //进程算法 默认fifo
        int processtype = 0;
        //分页算法 默认先进先出
        int pagetype = 0;
        //进程 页数
        maxpageNum = 0;
        //时间片长度
        int timeRound = 0;
        //页面大小
        int pageSize = 0;
        //分别赋值
        // 进程调度算法
        //1FCFS
        //2RR
        System.out.println("\t请选择进程调度算法");
        System.out.println("\t先来先服务(输入0)");
        System.out.println("\t时间片轮转(输入1)");
        if (sc.nextInt() == 1)
            processtype = 1;
        //分页调度机制
        //1FIFO
        //2LRU
        System.out.println("\t请选择分页算法");
        System.out.println("\t先进先出(输入0)");
        System.out.println("\t最近最少用(输入1)");
        if (sc.nextInt() == 1)
            pagetype = 1;
        //,进程页数
        System.out.println("\t请输入进程页数");
        maxpageNum = sc.nextInt();
        //输入 时间片长度
        System.out.println("\t请输入时间片长度(单位ms)");
        timeRound = sc.nextInt();
        //输入 页面大小
        System.out.println("\t请输入页面大小(单位kb)");
        pageSize = sc.nextInt();


        show();
        /*
         * 模拟进程调度
         */
        while (!readyQueue.isEmpty() || !queue.isEmpty() || !blockQueue.isEmpty()) {
            if (processtype == 1) rr(timeRound, pagetype, pageSize);
            else fcfs(pagetype, pageSize);
        }


        //显示进程的cpu占用和进程状态1ms刷新一次


        //将结果写入到文件中（result.txt）并保存，文件内容包括：运行时间、开始时间、完成时间、周转时间、带权周转时间
        File result = new File("result.txt");
        FileWriter fw = new FileWriter(result);
        BufferedWriter bw = new BufferedWriter(fw);

        if (!result.exists())
            result.createNewFile();
        for (Result r : endQueue) {
            bw.write(r.toString());
            bw.newLine();
        }
        bw.close();
        fw.close();
    }

    //process算法

    //先来先服务
    private static void fcfs(int pagetype, int pageSize) {
        if (readyQueue.isEmpty())
            readyQueue.offer(queue.poll());
        n = readyQueue.poll();
        //读取run的内容  开始执行
        List<Run> run = info.get(n.getProgram());
        int start = runTime;
        for (Run r : run) {
            runTime += r.getTime();
            log();
            if (r.getType() == (byte) 9) {
                System.out.println("当前进程结束\n");
                break;
            }
            if (r.getType() == (byte) 0) {// 0是跳转
                pageReplace(pagetype, r.getParam(), pageSize);
                System.out.println("第" + runTime + "ms 跳转到地址" + r.getParam() + "\n");
            } else {
                System.out.println("第" + runTime + "ms 进程阻塞" + r.getTime() + "ms\n");
                runTime += r.getParam();
                log();
            }
        }
        int end = runTime;
        //进程全部运行结束时计算每个进程的周转时间和带权周转时间
        endQueue.add(new Result(n, end - start, start, end, end, end / (end - start)));
    }

    //时间片轮转

    /**
     * @param timeRound 时间片
     */
    private static void rr(int timeRound, int pagetype, int pageSize) {
        if (readyQueue.isEmpty()) {
            readyQueue.offer(queue.poll());
        }
        //出队开始执行
        n = readyQueue.poll();

        //唤醒阻塞的进程
        for (PCB p : blockQueue) {
            List<Run> runs = info.get(p.getProgram());
            for (Run run : runs) {
                if (runTime > run.getParam() && run.getParam() > 0 || readyQueue.isEmpty() && queue.isEmpty()) {
                    run.setParam(0);
                    readyQueue.offer(p);
                }
            }
        }
        for (PCB p : readyQueue) {
            queue.remove(p);
            while (blockQueue.contains(p))
                blockQueue.remove(p);
        }


        int start = runTime;
        //读取run的内容  开始执行
        List<Run> run = info.get(n.getProgram());
        boolean isEnd = false;
        for (Run r : run) {
            if (r.getTime() < 1) {
                continue;
            }
            if (timeRound >= r.getTime()) {
                runTime += r.getTime();
                log();
                timeRound -= r.getTime();
                r.setTime(0);
                if (r.getType() == (byte) 9) {
                    System.out.println("当前进程结束\n");
                    isEnd = true;
                    break;
                }
                if (r.getType() == (byte) 0) {// 0是跳转  访问页面
                    System.out.println("第" + runTime + "ms 跳转到地址" + r.getParam() + "\n");
                    pageReplace(pagetype, r.getParam(), pageSize);
                } else {
                    System.out.println("第" + runTime + "ms 磁盘读写" + r.getParam() + "ms\n");
                    blockQueue.add(n);
                    r.setParam(r.getParam() + runTime);
                    break;
                }

            } else {
                runTime += timeRound;
                log();
                r.setTime(r.getTime() - timeRound);
                break;
            }
        }
        int end = runTime;
        if (isEnd) { // 全部执行结束 计算结果 结束
            //进程全部运行结束时计算每个进程的周转时间和带权周转时间
            for (Result res : endQueue) {
                readyQueue.remove(readyQueue);
                if (res.p.getProgram().equals(n.getProgram())) {
                    res.runtime += (end - start);
                    res.endTime = end;
                    res.cycTime = (int) (end - res.runtime);
                    res.wAroundTime = (int) ((end - res.runtime) / res.runtime);
                }
            }
        } else { //没执行完 继续排到就绪队列末尾
            if (!blockQueue.contains(n))
                readyQueue.offer(n);
            for (Result res : endQueue) {
                if (res.p.getProgram().equals(n.getProgram())) {
                    res.runtime += end - start;
                    return;
                }
            }
            endQueue.add(new Result(n, end - start, start, 0, 0, 0));
        }


    }


    //page算法
    //调用页面算法 通过参数选择置换算法
    private static void pageReplace(int pagetype, int addr, int pageSize) {
        if (pagetype == 1) lru(addr, pageSize);
        else fifo(addr, pageSize);
    }

    //最近最少使用

    /**
     * @param addr     请求地址
     * @param pageSize 页面大小
     */
    private static void lru(int addr, int pageSize) {
        if (!memeryPages.isEmpty())
            for (Page page : memeryPages) {
                if (page.getNum() == (addr / 1024)) {
                    //找到了就重新放到队尾
                    memeryPages.remove(page);
                    memeryPages.offer(page);
                    return;
                }
            }
        int num = 0;
        //如果没有就是缺页 从外存中找
        System.err.println("第" + runTime + "ms," + n.getName() + "访问页号" + addr / 1024 + "触发缺页中断");
        PCB nowProcess = n;
        HashMap<String, Float> map = programs.get(nowProcess.getProgram());
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String tmp = it.next();
            if (num > addr) {
                break;
            }
            num += map.get(tmp);
        }
        if (memeryPages.size() >= maxpageNum) {    //长度不足
            //将队首元素出队 最早最久未使用的淘汰
            System.out.println("页号为" + memeryPages.poll().getNum() + "从内存中删除");
        }
        System.out.println("页号为" + addr / 1024 + "从外存中新增");
        memeryPages.offer(new Page(addr / 1024, null, memeryPages.peekLast()));
    }


    //先进先出

    /**
     * @param addr     地址
     * @param pageSize 页面大小
     */
    private static void fifo(int addr, int pageSize) {
        //内存中有 内存中拿
        if (!memeryPages.isEmpty())
            for (Page page : memeryPages) {
                if (page.getNum() == (addr / 1024)) return;
            }
        //缺页  外存中取
        int num = 0;
        //如果没有就是缺页 从外存中找
        System.err.println("第" + runTime + "ms," + n.getName() + "访问页号" + addr / 1024 + "触发缺页中断");
        PCB nowProcess = n;
        HashMap<String, Float> map = programs.get(nowProcess.getProgram());
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String tmp = it.next();
            if (num > addr) {
                break;
            }
            num += map.get(tmp);
        }
        if (memeryPages.size() >= maxpageNum) {//长度不足
            System.out.println("页号为" + memeryPages.poll().getNum() + "从内存中删除");
        }
        //将队首元素出队 先进先出
        System.out.println("页号为" + addr / 1024 + "从外存中新增");
        memeryPages.offer(new Page(addr / 1024, null, memeryPages.peekLast()));

    }

    /**
     * 日志打印   进程状态变动时  打印日志;
     */
    private static void log() {
        for (int i = printtime + 1; i <= runTime; i++) {
            for (PCB process : queue) {
                if (process.getTime() < i) {
                    readyQueue.offer(process);
                    System.out.println(process.getName() + "在" + process.getTime() + "加入就绪队列\n");
                }
            }
            for (PCB pcb:readyQueue){
                queue.remove(pcb);
            }

            System.out.println("当前第" + i + "ms:");

//            Iterator<String> it = programs.keySet().iterator();
//            while (it.hasNext()) {
//                float memory = 0;
//                String key = it.next();
//                HashMap<String, Float> a = programs.get(key);
//                Iterator<Float> it1 = a.values().iterator();
//                while (it1.hasNext()) {
//                    memory += it1.next();
//                }
//                System.out.println(key + "占用内存" + memory + "k");
//            }
            System.out.println(n.getName() + "当前正在运行");
            for (PCB p : readyQueue)
                System.out.println(p.getName() + ":已就绪");
            for (PCB p : blockQueue)
                System.out.println(p.getName() + ":已阻塞");
            for (PCB p : queue) {
                System.out.println(p.getName() + ":未进入");
            }
            for (Result res : endQueue) {

                if (res.endTime != 0){
                    readyQueue.remove(res.p);
                    System.out.println(res.p.getName() + "已运行完成");

                }

            }
            System.out.println();
        }
        printtime = runTime;
    }

    private static void show() {
        System.out.println("---------------------------系统即将运行的信息------------------------------------");
        for (PCB p : readyQueue) {
            System.out.println("程序名称" + p.getName());
            System.out.println("-------程序信息");

            System.out.println("函数名\t大小");
            HashMap<String, Float> j = programs.get(p.getProgram());
            Set<HashMap.Entry<String, Float>> pro = j.entrySet();
            for (Map.Entry<String, Float> a : pro) {

                System.out.println(a.getKey() + "\t" + a.getValue());
            }
            int num = 0;
            System.out.println("关键时间节点\t操作类型\t 目的地或io时间");
            List<Run> list = info.get(p.getProgram());
            for (Run r : list) {
                num += r.getTime();
                String stype = "";
                if (r.getType() == 0)
                    stype = "跳转";
                else if (r.getType() == 9)
                    stype = "结束";
                else
                    stype = "读写磁盘";
                System.out.println(num + "\t" + stype + "\t" + r.getParam());
            }
            System.out.println();
        }


    }

    /*
     * 文件读取
     * */
    private static void readFile() throws IOException {
        FileReader pfileReader = null;
        BufferedReader processReader = null;
        FileReader programfileReader = null;
        BufferedReader programReader = null;
        FileReader runfileReader = null;
        BufferedReader runReader = null;
        try {
            File process = new File("./Process.txt");
            pfileReader = new FileReader(process);
            processReader = new BufferedReader(pfileReader);
            File program = new File("./program.txt");
            programfileReader = new FileReader(program);
            programReader = new BufferedReader(programfileReader);
            File run = new File("./run.txt");
            runfileReader = new FileReader(run);
            runReader = new BufferedReader(runfileReader);


            //读取Process文件 构造PCB对象存入就绪队列
            while (true) {
                String line = processReader.readLine();
                if (line == null) break;
                String[] s = line.split("\t");
                PCB p = new PCB(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), s[3]);
                queue.add(p);
            }
            HashMap<String, Float> map = null;


            //读取program文件
            String pname = "";
            while (true) {
                String line = programReader.readLine();
                if (line == null) {
                    programs.put(pname, map);
                    break;
                }
                if (line.equals("")) {
                    programs.put(pname, map);
                    continue;
                }
                if (line.contains("文件名")) {
                    String[] s = line.split(" ");
                    pname = s[1];
                    map = new HashMap<>();
                } else {
                    String[] s = line.split(" +");
                    assert map != null;
                    map.put(s[0], Float.parseFloat(s[1]));
                }
            }
            List<Run> list = null;
            //读取内存操作信息 run文件
            int pretime = 0;
            while (true) {
                String line = runReader.readLine();
                if (line == null) {
                    info.put(pname, list);
                    break;
                }
                if (line.equals("")) {
                    info.put(pname, list);
                    continue;
                }
                if (line.contains("程序")) {
                    pname = line;
                    list = new LinkedList<>();
                } else {
                    String[] s = line.split(" +");
                    assert list != null;
                    byte b = Objects.equals(s[1], "跳转") ? (byte) 0 : (byte) 1;
                    if (s[1].equals("结束"))
                        b = 9;
                    Run a = new Run(list.size() > 0 ? Integer.parseInt(s[0]) - pretime : Integer.parseInt(s[0]) - 0, b, Integer.parseInt(s[2]));
                    list.add(a);
                    pretime = Integer.parseInt(s[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pfileReader.close();
            processReader.close();
            programfileReader.close();
            programReader.close();
            runfileReader.close();
            runReader.close();
        }
    }

}


/**
 * 输出结果的对象映射
 */
class Result {
    //绑定的进程
    public PCB p;
    // 运行时间
    public long runtime;
    // 开始时间
    public int starttime;
    // 结束时间
    public int endTime;
    // 周转时间
    public int cycTime;
    // 带权周转时间
    public int wAroundTime;

    @Override
    public String toString() {
        return "进程=" + p.getName() +
                ", 运行时间=" + runtime +
                ", 开始时间=" + starttime +
                ", 结束时间=" + endTime +
                ", 周转时间=" + cycTime +
                ", 带权周转时间=" + wAroundTime;
    }

    public Result(PCB p, int runtime, int starttime, int endTime, int cycTime, int wAroundTime) {
        this.p = p;
        this.runtime = runtime;
        this.starttime = starttime;
        this.endTime = endTime;
        this.cycTime = cycTime;
        this.wAroundTime = wAroundTime;
    }
}

/*
 *   页面对象映射
 * */
class Page {
    //页码
    private int num;
    //下一个
    private Page next;
    //上一个
    private Page pre;

    @Override
    public String toString() {
        return "Page{" +
                "num=" + num +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }

    public Page(int num, Page next, Page pre) {
        this.num = num;
        this.next = next;
        this.pre = pre;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Page getNext() {
        return next;
    }

    public void setNext(Page next) {
        this.next = next;
    }

    public Page getPre() {
        return pre;
    }

    public void setPre(Page pre) {
        this.pre = pre;
    }


}

/*
 * 运行信息映射
 * */
class Run {
    //关键时间节点 是相对开始的时间值
    private int time;
    //0跳转  1读写 9结束
    private byte type;
    //目的地 或io操作时间
    private int param;

    @Override
    public String toString() {
        return "Run{" +
                "time=" + time +
                ", type=" + type +
                ", param=" + param +
                '}';
    }

    public Run(int time, byte type, int param) {
        this.time = time;
        this.type = type;
        this.param = param;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }
}

/*
 *
 * 进程管理块映射
 * */
class PCB {
    private String name; //进程名
    private int priority;//优先级
    private int time;   //运行时间
    private String program; //程序名

    public PCB(String name, int time, int priority, String program) {
        this.name = name;
        this.priority = priority;
        this.time = time;
        this.program = program;
    }

    @Override
    public String toString() {
        return "PCB{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", time=" + time +
                ", program='" + program + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}