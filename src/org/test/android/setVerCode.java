
package org.test.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class setVerCode extends Task
{
    private static String src;
    private static String dir;
    static FileInputStream fin = null;
    static FileInputStream fVer = null;
    static BufferedReader br = null;
    static String line = null;
    private static String verCode;
    private static String versionName;
    private static String tmp;
    static FileWriter fw;
    static String verNameStr = null;

    public void setSrc(String src)
    {
        src = src;
    }

    public void setDir(String dir) {
        dir = dir;
    }

    public void execute()
            throws BuildException
    {
        File fileVersion = new File(src + "/" + "verName.txt");
        System.out.println(src);
        System.out.println(dir);
        if (!(fileVersion.exists())) {
            throw new BuildException("need a verName.txt content older versionName and versioncode"
                    +
                    src);
        }

        setVerCode();
    }

    public static void setVerCode() {
        String fileName = dir + "/" + "AndroidManifest.xml";
        try {
            Attribute attribute;
            File fileVersion = new File(src + "/" + "verName.txt");
            fVer = new FileInputStream(fileVersion);
            if (!(fileVersion.exists()))
                return;
            String[] tmpStr = null;
            br = new BufferedReader(new InputStreamReader(fVer));
            while ((setVerCode.line = br.readLine()) != null)
                tmpStr = line.split("_");

            SAXReader reader = new SAXReader();

            Document document = reader.read(new File(fileName));
            List list = document.selectNodes("/manifest/@android:versionCode");
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                attribute = (Attribute) iter.next();
                verCode = attribute.getValue();
            }
            list = document.selectNodes("/manifest/@android:versionName");
            iter = list.iterator();
            while (iter.hasNext()) {
                attribute = (Attribute) iter.next();
                versionName = attribute.getValue();
            }

            if (versionName.equalsIgnoreCase(tmpStr[0])) {
                int ver = Integer.parseInt(verCode) + 1;

                int verCodeNum = Integer.parseInt(tmpStr[1]) + 1;
                System.out.println(verCodeNum);
                verCode = String.valueOf(verCodeNum);
                System.out.println(tmpStr[1]);
                list = document.selectNodes("/manifest/@android:versionCode");
                iter = list.iterator();
                while (iter.hasNext()) {
                    attribute = (Attribute) iter.next();
                    attribute.setValue(verCode);
                }
            }
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setIndentSize(2);
            format.setNewlines(true);

            format.setPadText(true);
            format.setEncoding("UTF-8");
            FileOutputStream fos = new FileOutputStream(fileName);

            XMLWriter writer = new XMLWriter(fos, format);
            writer.write(document);
            writer.close();
            System.out.println(versionName + "_" + verCode);
            fileVersion.delete();
            fileVersion = new File(src + "/" + "verName.txt");
            fw = new FileWriter(src + "/" + "verName.txt");
            fw.write(versionName);
            fw.write("_");
            fw.write(verCode);
            if (fw == null)
                return;
            try {
                fw.close();
            } catch (Exception localException1)
            {
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
    }
}
