package com.conpany.project;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.function.Function;
import java.util.function.Predicate;

public class Test {

    public static void predicate(){
        Predicate<String> nameStringWiths = name -> name.startsWith("s");
        boolean hello = nameStringWiths.test("helo");
        System.out.println(hello);
    }

    public static void main(String[] args) {

        String code = "611411 ";
        if (code.length() < 6 || code.length() > 12){
            System.out.println("扫码信息不正确,请重新扫码,工单号长度必须是6-10位,code:"+code);
        }

        boolean sss = NumberUtils.isNumber("061 1895");
        boolean sss1 = NumberUtils.isParsable("061 1895");
        System.out.println(sss+":"+sss1);

        String fileContent = "1   X2FS140e/HU/B                                                                                                                                                                                                                                                 0.99     25.8077346705.0001.21.47      CLP HC 320                                                                                                                                                                                                                                                                                                        1651437.0    203.2532          160.00         2.84    7.07        7337    160.00  456.00  IM:M1F1                                            0       40      eof\n";

        System.out.println(fileContent.substring(60,90).trim());

        System.out.println(fileContent.substring(4,34).trim());

        System.out.println(fileContent.substring(267,297).trim());
        String seq = fileContent.substring(267,297).trim().replace(".","");

        System.out.println(seq.substring(2,12));
        System.out.println(fileContent.substring(297,327).trim());

        //型号

        //序列号
        System.out.println("#################################");

        String remoteSeq = "2581349777595959595";
        String reSeq = remoteSeq.substring(2,12);
        String currentSeq = "81349777595959595";
        String currS = currentSeq.substring(0,10);
        System.out.println("reSeq="+reSeq+",currS="+currS);
        System.out.println(reSeq.equals(currS));

        String ss1 = "123";
        String ss12 = ss1.substring(0,2);
        System.out.println(ss12);
        predicate();
        Function<Integer,String[]> fun1 = String[]::new;
        String[] ss = fun1.apply(20);
        System.out.println(ss.length);
    }

}
