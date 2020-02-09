package svn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import cn.sy.frdz.svn.SVN;
import frey.platform.builder.AutoBuilderMain;

/**
 * 自动调用项目最新版本号打版
 * 
 * @author Tengt
 * @date 2019年9月6日
 * @description
 */
public class AutoBuilderProject {
	static SVNRepository repository;
	// 打版文件夹时间后缀格式
	static SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
	// svn位置
	static String svnRoot = "svn://192.168.199.197/svnroot/";
	// svn项目位置
	static String projectPath = "tag/projects/";
	// svn username
	static String username = "tengt";
	// svn password
	static String password = "wdmms:GBBESWDW1";
	// 打版存放位置根目录
	static String rootPath = "d:\\";
	// 项目全名
	// static String projectName = "CEKE_coalTrans";// 策克项目
	static String projectName = "GQMD_CoalTransportation";// 中蒙跨境项目
	// static String projectName = "parking";// 卡口项目
	// static String projectName = "MeiHua_itn2_0";// 美华项目

	public static void main(String[] args) throws SVNException, InterruptedException {

		SVN.auth(svnRoot, username, password);
		repository = SVN.getRepository();
		List<String> svnDirEntryNames = SVN.getSVNDirEntryNames(projectPath + projectName);
		String newVersion = svnDirEntryNames.get(0);
		System.out.println("打版项目名: " + projectName);
		System.out.println("打版版本号: " + newVersion);
		String workingroot = getWorkingRoot(projectName);
		String[] argss = { "-project", projectName, "-projver", newVersion, "-workdir", workingroot };
		Thread.sleep(2000);
		AutoBuilderMain.main(argss);
	}

	private static String getWorkingRoot(String projectName) {

		String date = sdf.format(new Date());
		String fileName = "auto_build" + "_" + projectName + "_" + date + "\\";
		String result = rootPath + fileName;
		System.out.println("打版文件放置位置: " + result);
		return result;
	}

	@Test
	public void testGetWorkingRoot() {
		getWorkingRoot("CEKE_coalTrans");
	}
}
