package data.mhs.datamahasiswa.controller;

import data.mhs.datamahasiswa.entity.DataMhs;
import data.mhs.datamahasiswa.model.DataMhsModel;
import data.mhs.datamahasiswa.services.DataMhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private DataMhsService service;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("data", service.getAllData());
        return "index";
    }

    @GetMapping("/tambah")
    public String tampilkanTambahForm(Model model) {
        model.addAttribute("data", new DataMhsModel());
        return "tambahData";
    }

    @PostMapping("/simpan")
    public String simpan(DataMhsModel data) {
        service.save(service.convertToEntity(data));
        return "redirect:/";
    }

    @GetMapping("/ubah/{nim}")
    public String ubah(@PathVariable("nim") String nim, Model model) {
        Optional<DataMhs> result = service.findById(nim);
        if(result.isPresent()) {
            DataMhs data1 = result.get();
            model.addAttribute("data", data1);
            return "ubahData";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/hapus/{nim}")
    public String hapus(@PathVariable("nim") String nim) {
        service.removeById(nim);
        return "redirect:/";
    }
}