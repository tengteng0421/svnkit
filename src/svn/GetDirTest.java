package svn;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import cn.sy.frdz.svn.SVN;

public class GetDirTest {
	static String svnRoot = "svn://192.168.199.197/svnroot/";
	static String username = "tengt";
	static String password = "wdmms:GBBESWDW1";
	static SVNRepository repository;

	public static void main(String[] args) throws SVNException {
		SVN.auth(svnRoot, username, password);
		repository = SVN.getRepository();
		SVNDirEntry dir = repository.getDir("/trunk/frameworks/ApplicationFramework.core", -1, true, null);
		System.out.println(dir.getURL() + " " + dir.getAuthor() + " " + dir.getDate() + " " + dir.getCommitMessage());
	}
}
