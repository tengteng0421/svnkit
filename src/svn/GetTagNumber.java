package svn;

import java.util.List;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import cn.sy.frdz.svn.SVN;

public class GetTagNumber {
	static String svnRoot = "svn://192.168.199.197/svnroot/";
	static String projectPath = "tag/projects/";
	static String username = "tengt";
	static String password = "wdmms:GBBESWDW1";
	static SVNRepository repository;

	public static void main(String[] args) throws SVNException {
		String projectName = "GQMD_CoalTransportation";
		SVN.auth(svnRoot, username, password);
		repository = SVN.getRepository();
		List<String> svnDirEntryNames = SVN.getSVNDirEntryNames(projectPath + projectName);
		String newVersion = svnDirEntryNames.get(0);
		System.out.println("项目名: " + projectName);
		System.out.println("版本号: " + newVersion);
	}
}
