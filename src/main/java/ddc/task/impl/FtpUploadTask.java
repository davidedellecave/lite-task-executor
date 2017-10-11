package ddc.task.impl;

import ddc.ftp.FtpLiteClient;
import ddc.ftp.FtpLiteConfig;
import ddc.ftp.FtpLiteException;
import ddc.support.task.Task;
import ddc.support.util.FilePair;
import ddc.task.model.FileBag;

public class FtpUploadTask extends Task {
	public final static String PARAMNAME_SERVERCONFIG="ftp.config.upload";
	
	@Override
	public void doRun() throws FtpLiteException {
		FtpLiteClient ftp = null;
		try {
			FtpLiteConfig ftpConf = (FtpLiteConfig) get(PARAMNAME_SERVERCONFIG);
			FileBag fileBag = (FileBag) get(FileBag.class);
			//
			ftp = new FtpLiteClient(ftpConf);
			ftp.connect();
			//
			for (FilePair fp : fileBag.fileToUpload) {
				ftp.upload(fp.source, fp.target);
			}
		} finally {
			if (ftp != null)
				ftp.disconnect();
		}
	}
}