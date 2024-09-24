package com.ld.webtruonghoc.controller;

import com.ld.webtruonghoc.entity.Hocsinh;
import com.ld.webtruonghoc.repo.HocSinhRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HocSinhController {
    private final HocSinhRepo hocSinhRepo;

    public HocSinhController(HocSinhRepo hocSinhRepo) {
        this.hocSinhRepo = hocSinhRepo;
    }

    @RequestMapping("")
    public String getAll(Model model){

//        return searchPaginated(model, 1,"id", "asc", "id","");
        return "redirect:/page/1";
    }

    @RequestMapping("/page/{pageNo}")
    public String searchPaginated(Model model,
                         @PathVariable("pageNo") Integer pageNo,
                                  @RequestParam(defaultValue = "id") String sortField,
                                  @RequestParam(defaultValue = "asc") String sortDir,
                                  @RequestParam(defaultValue = "id") String searchField,
                                  @RequestParam(defaultValue = "") String keyword){
        int pageSize = 5;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        String searchFieldLower = searchField.toLowerCase();
        Page<Hocsinh> hocsinhPage;
        switch (searchFieldLower){
            case "id":
                hocsinhPage = hocSinhRepo.searchByID(keyword, pageable);
                break;
            case "họ tên":
                hocsinhPage = hocSinhRepo.searchByName(keyword, pageable);
                break;
            case "giới tính":
                hocsinhPage = hocSinhRepo.searchByGender(keyword, pageable);
                break;
            case "ngày sinh":
                hocsinhPage = hocSinhRepo.searchByDOB(keyword, pageable);
                break;
            case "email":
                hocsinhPage = hocSinhRepo.searchByEmail(keyword, pageable);
                break;
            case "sdt":
                hocsinhPage = hocSinhRepo.searchBySDT(keyword, pageable);
                break;
            case "lớp":
                hocsinhPage = hocSinhRepo.searchByLop(keyword, pageable);
                break;
            default:
                return "redirect:/";
        }
        List<Hocsinh> hocsinhList = hocsinhPage.getContent();
        model.addAttribute("searchField", searchField);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", hocsinhPage.getTotalPages());
        model.addAttribute("totalHocsinh", hocsinhPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("hocsinhList", hocsinhList);
        return "hocsinhlist.html";
    }

    @GetMapping("/new")
    public String showAddForm(Model model){
        model.addAttribute("hocsinh", new Hocsinh());
        model.addAttribute("pageTitle", "Thêm học sinh");
        return "hocsinh_add_form.html";
    }

    @PostMapping("/save")
    public String addHocsinh(Hocsinh hocsinh){
        hocSinhRepo.save(hocsinh);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        try{
            Optional<Hocsinh> hocsinh = hocSinhRepo.findById(id);
            model.addAttribute("hocsinh", hocsinh);
            model.addAttribute("pageTitle", "Sửa thông tin học sinh có ID: " + id);
            return "hocsinh_add_form.html";
        } catch(Exception e){
            e.printStackTrace();
            return "redirect:/";
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try{
            hocSinhRepo.deleteById(id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
