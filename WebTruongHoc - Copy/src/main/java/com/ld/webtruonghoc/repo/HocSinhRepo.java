package com.ld.webtruonghoc.repo;

import com.ld.webtruonghoc.entity.Hocsinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HocSinhRepo extends JpaRepository<Hocsinh, Integer> {
//    @Query("SELECT hocsinh from Hocsinh hocsinh where CONCAT(hocsinh.hoten, '', hocsinh.gioitinh, '', hocsinh.ngaysinh, '', hocsinh.email, '', hocsinh.sdt, '', hocsinh.lop, '') like %?1%")
//    Page<Hocsinh> search(String keyword, Pageable pageable);
    @Query("SELECT hocsinh from Hocsinh hocsinh where CONCAT(hocsinh.id, '') like %?1%")
    Page<Hocsinh> searchByID(String keyword, Pageable pageable);
    @Query("SELECT hocsinh from Hocsinh hocsinh where CONCAT(hocsinh.hoten, '') like %?1%")
    Page<Hocsinh> searchByName(String keyword, Pageable pageable);
    @Query("SELECT hocsinh from Hocsinh hocsinh where CONCAT(hocsinh.gioitinh, '') like %?1%")
    Page<Hocsinh> searchByGender(String keyword, Pageable pageable);
    @Query("SELECT hocsinh from Hocsinh hocsinh where CONCAT(hocsinh.ngaysinh, '') like %?1%")
    Page<Hocsinh> searchByDOB(String keyword, Pageable pageable);
    @Query("SELECT hocsinh from Hocsinh hocsinh where CONCAT(hocsinh.email, '') like %?1%")
    Page<Hocsinh> searchByEmail(String keyword, Pageable pageable);
    @Query("SELECT hocsinh from Hocsinh hocsinh where CONCAT(hocsinh.sdt, '') like %?1%")
    Page<Hocsinh> searchBySDT(String keyword, Pageable pageable);
    @Query("SELECT hocsinh from Hocsinh hocsinh where CONCAT(hocsinh.lop, '') like %?1%")
    Page<Hocsinh> searchByLop(String keyword, Pageable pageable);
}
