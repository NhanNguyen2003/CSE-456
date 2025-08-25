package vn.edu.eiu.practice_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.practice_final.model.Major;
import vn.edu.eiu.practice_final.repository.MajorRepo;

import java.util.List;

@Service
public class MajorService {

    @Autowired
    private MajorRepo majorRepo;

    // hàm phục vụ lưu major xuống db
    public void saveMajor(Major major){majorRepo.save(major);}

    // hàm phục vụ lấy tất cả major làm comboBox
    public List<Major> getAllMajor() { return majorRepo.findAll();}
}
