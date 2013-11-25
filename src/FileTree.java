import java.io.*;

public class FileTree {
	public static void main(String args[]) {
		String pathname = "/home/wzy/test/test";
		
		printFileTree(pathname, 0);
	}
	
	public static void printFileTree(String pathname, int level) {
		File fh = new File(pathname);
		
		if (fh.exists() == false) {
			return;
		} else{
			for (int i = 0; i < level; i ++) {
				System.out.printf("\t");
			}
			
			if (fh.isDirectory()) {
				System.out.printf("%s:\n", fh.getName());
				String[] dir = fh.list();
				for (int i = 0; i < dir.length; i ++) {
					printFileTree(fh.getAbsolutePath() + "/" + dir[i], level + 1);
				}
			} else {
				System.out.printf("%s\n", fh.getName());
			}
		}
	}
}

