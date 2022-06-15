package sort;

import com.jcraft.jsch.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

public class FtpTesting {
    public static void main(String[] args) {
        String fileName = sftpDownloadCdrFile();
        System.out.println(fileName + " was downloaded");
        NodeList nList = getNodeList(fileName);

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element : " + temp + ". " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("spname" + " : " + getValueOfElement(eElement, "spname"));
                System.out.println("msisdn" + " : " + getValueOfElement(eElement, "msisdn"));

                System.out.println("Subscriberfee.Activedays" + " : " + getValueOfElement(eElement, "Subscriberfee", "Activedays"));
                System.out.println("Subscriberfee.Totaldays" + " : " + getValueOfElement(eElement, "Subscriberfee", "Totaldays"));
                System.out.println("Subscriberfee.Amount" + " : " + getValueOfElement(eElement, "Subscriberfee", "Amount"));

                System.out.println("AlphaNumberFee.Activedays" + " : " + getValueOfElement(eElement, "AlphaNumberFee", "AlphaNumberName"));
                System.out.println("AlphaNumberFee.Totaldays" + " : " + getValueOfElement(eElement, "AlphaNumberFee", "Tariff"));
                System.out.println("AlphaNumberFee.Amount" + " : " + getValueOfElement(eElement, "AlphaNumberFee", "Amount"));
            }
        }
    }

    private static NodeList getNodeList(String fileName) {
        NodeList nList = null;
        File fXmlFile = new File("cdr/" + fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("sp");

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return nList;
    }

    private static String getValueOfElement(Element eElement, String name) {
        try {
            return eElement.getElementsByTagName(name).item(0).getTextContent();
        } catch (Exception ignore) {
        }
        return null;
    }

    private static String getValueOfElement(Element eElement, String name, String subName) {
        try {
            NodeList child = eElement.getElementsByTagName(name).item(0).getChildNodes();
            for (int i = 0; i < child.getLength(); i++) {
                if (child.item(i).getNodeName().equalsIgnoreCase(subName)) {
                    return child.item(i).getTextContent();
                }
            }
        } catch (Exception ignore) {
        }
        return null;
    }

    private static String sftpDownloadCdrFile() {
        String fileName = null;
        JSch jsch = new JSch();
        Session session;
        try {
            session = jsch.getSession("ium", "vm-obm-int.dc", 22);
            Properties properties = new Properties();
            properties.setProperty("StrictHostKeyChecking", "no");
            session.setConfig(properties);
            session.setPassword("password");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            Vector filelist = sftpChannel.ls("/data/ium/ium");
            ChannelSftp.LsEntry lastFile = (ChannelSftp.LsEntry) filelist.get(filelist.size() - 1);

            fileName = lastFile.getFilename();
            sftpChannel.get("/data/ium/ium/" + fileName, "cdr/" + fileName);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        } finally {
            return fileName;
        }
    }
}
