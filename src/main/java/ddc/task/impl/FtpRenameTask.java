package ddc.task.impl;

import org.apache.log4j.Logger;

import ddc.ftp.FtpLiteClient;
import ddc.ftp.FtpLiteConfig;
import ddc.ftp.FtpLiteException;
import ddc.support.task.Task;
import ddc.support.util.FilePair;
import ddc.task.model.FileBag;

public class FtpRenameTask extends Task {
	private final static Logger logger = Logger.getLogger(FtpRenameTask.class);
	public final static String PARAMNAME_CONFIG="ftp.config.rename";

	@Override
	public void  doRun() throws FtpLiteException {
		FtpLiteClient ftp = null;
		try {
			FtpLiteConfig ftpConf = (FtpLiteConfig) get(PARAMNAME_CONFIG);
			FileBag fileBag = (FileBag) get(FileBag.class);
			//
			ftp = new FtpLiteClient(ftpConf);
			ftp.connect();
			//
			String info = "Ftp renaming - file #:[" + fileBag.remoteFileToRename.size() + "]";
			if (fileBag.remoteFileToRename.size() == 0) {
				logger.error(info);
				throw new FtpLiteException(info);
			} else {
				logger.info(info);
			}
			//
			for (FilePair fp : fileBag.remoteFileToRename) {
				ftp.rename(fp.source, fp.target);
			}
		} finally {
			if (ftp != null)
				ftp.disconnect();
		}
	}

}
