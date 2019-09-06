package svn;

import java.util.List;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import cn.sy.frdz.svn.SVN;
import frey.platform.builder.AutoBuilderMain;

public class AutoBuilderProject {
	static String svnRoot = "svn://192.168.199.197/svnroot/";
	static String projectPath = "tag/projects/";
	static String username = "tengt";
	static String password = "wdmms:GBBESWDW1";
	static SVNRepository repository;

	public static void main(String[] args) throws SVNException {
		// String projectName = "GQMD_CoalTransportation";
		String projectName = "CEKE_coalTrans";
		SVN.auth(svnRoot, username, password);
		repository = SVN.getRepository();
		List<String> svnDirEntryNames = SVN.getSVNDirEntryNames(projectPath + projectName);
		String newVersion = svnDirEntryNames.get(0);
		System.out.println("项目名: " + projectName);
		System.out.println("版本号: " + newVersion);
		String workingroot = getWorkingRoot();
		String[] argss = { "-project", projectName, "-projver", newVersion, "-workdir", workingroot };
		AutoBuilderMain.main(argss);
	}

	private static String getWorkingRoot() {
		return "d:\\auto_build0906_ceke_1\\";
	}
}
