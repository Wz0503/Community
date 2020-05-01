package com.nowcoder.community;

import java.io.IOException;

/**
 * @author wz
 * @date 2020/4/30 11:01
 */

public class WkTests {

    public static void main(String[] args) {
        String cmd = "d:/common/wkhtmltopdf/bin/wkhtmltoimage --quality 75 https://www.nowcoder.com d:/work/workspace/data/wk-images/3.png";
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
