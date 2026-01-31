package poly.edu.ASSM.Services.util;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileService {
	    private final String UPLOAD_DIR = "uploads";

	    // Lưu file upload
	    public String save(MultipartFile file) throws IOException {
	        if (file.isEmpty()) return null;

	        File dir = new File(UPLOAD_DIR);
	        if (!dir.exists()) dir.mkdirs();

	        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
	        File saveFile = new File(dir, fileName);

	        file.transferTo(saveFile);

	        return fileName;
	    }

	    // Xóa file
	    public boolean delete(String fileName) {
	        File file = new File(UPLOAD_DIR + "/" + fileName);
	        return file.exists() && file.delete();
	    }

	    // Lấy đường dẫn file
	    public String getPath(String fileName) {
	        return UPLOAD_DIR + "/" + fileName;
	    }
	}


