package cn.ding.template.backend.dao.oss.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

/**
 * This demo code show you how to use oss in your application. You can use is directly or
 * refactor is to implement your own logic|architecture.
 *
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Service
public class OssDemoService {
//
//	@Autowired
//	private OSS ossClient;
//
//	/**
//     * the file in local machine.
//	 */
//	@Value("classpath:/oss-test.json")
//	private Resource localFile;
//
//	/**
//	 * the file in oss remote server.
//	 */
//	@Value("oss://" + OssConfig.BUCKET_NAME + "/oss-test.json")
//	private Resource remoteFile;
//
//	public String readRemoteFileViaResource() throws IOException {
//		return IOUtils.readStreamAsString(remoteFile.getInputStream(),
//				CharEncoding.UTF_8);
//	}
//
//	public String readRemoteFileViaClient() throws IOException {
//		OSSObject ossObject = ossClient.getObject(OssConfig.BUCKET_NAME, "oss-test.json");
//		return IOUtils.readStreamAsString(ossObject.getObjectContent(),
//				CharEncoding.UTF_8);
//	}
//
//	public void uploadWithClient() {
//		ossClient.putObject(OssConfig.BUCKET_NAME, "oss-test.json",
//				this.getClass().getClassLoader().getResourceAsStream("oss-test.json"));
//	}
//
//	public void uploadWithOutputStream() throws IOException {
//		try (OutputStream out = ((WritableResource) this.remoteFile).getOutputStream();
//             InputStream in = localFile.getInputStream()) {
//			StreamUtils.copy(in, out);
//		}
//	}
}
