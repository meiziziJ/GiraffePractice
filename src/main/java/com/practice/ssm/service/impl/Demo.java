package com.practice.ssm.service.impl;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-16 8:51
 * 面试笔录
 */
public class Demo {

    //1、一个".java"源文件中是否可以包括多个类（不是内部类）？有什么限制？

    //2、&和&&的区别。
    /*
    * &和&&都可以用作逻辑与的运算符，表示逻辑与（and），当运算符两边的表达式的结果都为 true 时，整个运算结果才为 true，否
则，只要有一方为 false，则结果为 false。
    &&还具有短路的功能，即如果第一个表达式为 false，则不再计算第二个表达式，例如，对于 if(str != null && !str.equals(“”))表达式，
当str为null时，后面的表达式不会执行，所以不会出现NullPointerException如果将&&改为&，则会抛出NullPointerException异常。If(x==33
& ++y>0) y 会增长，If(x==33 && ++y>0)不会增长
    &还可以用作位运算符，当&操作符两边的表达式不是 boolean 类型时，&表示按位与操作，我们通常使用 0x0f 来与一个整数进行
&运算，来获取该整数的最低 4 个 bit 位，例如，0x31 & 0x0f 的结果为 0x01。
    * */
    public static void main(String[] args) {
        /*String str = "null";
        if(str == "null" && str.equals("null")){
            System.out.println("哦，天呐，好可怕，原来如此，真是太棒了，非常6+1呀");
        }

        System.out.println(0x31&0x0f);

        int x = 0;
        int y = 0;

        if(x == 33 & ++y > 0) {
        }
        if(y > 0){
            System.out.println("y进行了增加：y的值是"+y);
        }
        if(x == 33 & ++y > 0) {
        }
        if(y == 0){
            System.out.println("y没有进行增加：y的值依然是"+y);
        }*/
        //综上所述，得：
        //  当使用&&时，因为&&特性体现是前一方结果为true继续进行判断，为false则终止下面判断，所以y没有进行增加
        //  当使用&时，因为&特性是不管判断的前一方为true或false都会进行后面的判断，所以y进行了增加

        //4、在 JAVA 中，如何跳出当前的多重嵌套循环？
        /*在 Java 中，要想跳出多重循环，可以在外面的循环语句前定义一个标号，
        然后在里层循环体的代码中使用带有标号的 break 语句，
        即可跳出外层循环。例如*/
      /* ok:
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                System.out.println("i=" + i + ",j=" + j);
                if(j == 5) break ok;
            }
        }*/
       /*
        另外，我个人通常并不使用标号这种方式，
        而是让外层的循环条件表达式的结果可以受到里层循环体代码的控制，例如，要在二
        维数组中查找到某个数字
        */
        /*boolean found = false;
        for(int i=0;i<10 && !found;i++) {
            for(int j=0;j<10;j++) {
                System.out.println("i=" + i + ",j=" + j);
                if(j == 5) {
                    found = true;
                    break;
                }
            }
        }*/
        //当i=0，！found为true进行第一次循环时，到j累加到5时，将found改为true使用break结束里层循环，再次来到外层i的循环，
        // 但是此时found更改为true使用！found使得外层循环停止

        //5、switch 是否能作用在 byte 上，是否能作用在 long 上，是否能作用在 String 上?
        /*byte byt = 1;
        switch (byt){
            case 0:
                System.out.println("这个是0诶");
                break;
            case 1:
                System.out.println("对了咯是1嘞");
                break;
        }*/

        //6、short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错?
        /*short s1 = 1;
        System.out.println(s1 += 1);*/

        //7、char 型变量中能不能存贮一个中文汉字?为什么?
        char s = '是';
        char e = 1;
    }

}
