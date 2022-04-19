package Reports;

import com.faizan.service.user.service.user.Student;
import com.faizan.service.user.service.user.StudentService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    StudentService studentService;


}
