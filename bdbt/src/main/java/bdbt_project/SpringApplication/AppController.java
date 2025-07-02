package bdbt_project.SpringApplication;
import bdbt_project.SpringApplication.DAO.*;
import bdbt_project.SpringApplication.classes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/data_admin").setViewName("admin/data_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/data_user").setViewName("user/data_user");
        registry.addViewController("/main_client").setViewName("client/main_client");
        registry.addViewController("/data_client").setViewName("client/data_client");

        registry.addViewController("/new_klienci").setViewName("new_forms/new_klienci");
        registry.addViewController("/new_pracownicy").setViewName("new_forms/new_pracownicy");
        registry.addViewController("/new_stacje").setViewName("new_forms/new_stacje");
        registry.addViewController("/new_producenci").setViewName("new_forms/new_producenci");
        registry.addViewController("/new_reklamy").setViewName("new_forms/new_reklamy");

        registry.addViewController("/edit_klienci").setViewName("edit_forms/edit_klienci");
        registry.addViewController("/edit_pracownicy").setViewName("edit_forms/edit_pracownicy");
        registry.addViewController("/edit_stacje").setViewName("edit_forms/edit_stacje");
        registry.addViewController("/edit_producenci").setViewName("edit_forms/edit_producenci");
        registry.addViewController("/edit_reklamy").setViewName("edit_forms/edit_reklamy");




    }

    @Controller
    public class DashboardController
    {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else if
            (request.isUserInRole("CLIENT")) {
                return "redirect:/main_client";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }

    @Controller
    public class AdminController
    {
        @RequestMapping("/data_admin")
        public String showAdminData(Model model) {
            String cos = "cos";
            List<Pracownicy> listPracownicy = pracownicyDAO.list();
            model.addAttribute("listPracownicy", listPracownicy);
            model.addAttribute("cos", cos);
            return "admin/data_admin";
        }

    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }



    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }




    @RestController
    public class RestCreateController {
        @GetMapping("/api/Pracownicy")
        public List<Pracownicy> listPracownicy() {
            List<Pracownicy> listPracownicy = pracownicyDAO.list();
            System.out.println(listPracownicy);
            return listPracownicy;
        }
        @GetMapping("/api/Klienci")
        public List<Klienci> listKlienci() {
            List<Klienci> listKlienci = klienciDAO.list();
            System.out.println(listKlienci);
            return listKlienci;
        }
        @GetMapping("/api/Producenci")
        public List<Producenci_telewizyjno_radiowi> listProducenci() {
            List<Producenci_telewizyjno_radiowi> listProducenci = producenci_telewizyjno_radiowiDAO.list();
            System.out.println(listProducenci);
            return listProducenci;
        }
        @GetMapping("/api/Reklamy")
        public List<Reklamy> listReklamy() {
            List<Reklamy> listReklamy = reklamyDAO.list();
            System.out.println(listReklamy);
            return listReklamy;
        }
        @GetMapping("/api/Stacje")
        public List<Stacje> listStacje() {
            List<Stacje> listStacje = stacjeDAO.list();
            System.out.println(listStacje);
            return listStacje;
        }

    }

    @Controller
    public class AddController{
        @RequestMapping("/new_klienci")
        public String showNewKlienciForm(Model model) {
            Klienci klienci = new Klienci();
            model.addAttribute("klienci", klienci);
            return "new_forms/new_klienci";
        }
        @RequestMapping(value = "/save_klienci", method = RequestMethod.POST)
        public String saveKlienci(@ModelAttribute("klienci") Klienci klienci, Authentication authentication) {
            klienciDAO.save(klienci);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
        @RequestMapping("/new_pracownicy")
        public String showNewPracownicyForm(Model model) {
            Pracownicy pracownicy = new Pracownicy();
            model.addAttribute("pracownicy", pracownicy);
            return "new_forms/new_pracownicy";
        }
        @RequestMapping(value = "/save_pracownicy", method = RequestMethod.POST)
        public String savePracownicy(@ModelAttribute("pracownicy") Pracownicy pracownicy, Authentication authentication) {
            pracownicyDAO.save(pracownicy);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
        @RequestMapping("/new_producenci")
        public String showNewProducenciForm(Model model) {
            Producenci_telewizyjno_radiowi producenci_telewizyjno_radiowi = new Producenci_telewizyjno_radiowi();
            model.addAttribute("producenci_telewizyjno_radiowi", producenci_telewizyjno_radiowi);
            return "new_forms/new_producenci";
        }
        @RequestMapping(value = "/save_producenci", method = RequestMethod.POST)
        public String saveProducenci(@ModelAttribute("producenci_telewizyjno_radiowi") Producenci_telewizyjno_radiowi producenci_telewizyjno_radiowi, Authentication authentication) {
            producenci_telewizyjno_radiowiDAO.save(producenci_telewizyjno_radiowi);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
        @RequestMapping("/new_reklamy")
        public String showNewReklamyForm(Model model) {
            Reklamy reklamy = new Reklamy();
            model.addAttribute("reklamy", reklamy);
            return "new_forms/new_reklamy";
        }
        @RequestMapping(value = "/save_reklamy", method = RequestMethod.POST)
        public String saveReklamy(@ModelAttribute("reklamy") Reklamy reklamy, Authentication authentication) {
            reklamyDAO.save(reklamy);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
        @RequestMapping("/new_stacje")
        public String showNewStacjeForm(Model model) {
            Stacje stacje = new Stacje();
            model.addAttribute("stacje", stacje);
            return "new_forms/new_stacje";
        }
        @RequestMapping(value = "/save_stacje", method = RequestMethod.POST)
        public String saveStacje(@ModelAttribute("stacje") Stacje stacje, Authentication authentication) {
            stacjeDAO.save(stacje);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
    }

    @Controller
    public class EditController{
        @RequestMapping("/edit/klienci/{id}")
        public ModelAndView showEditKlienciForm(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("edit_forms/edit_klienci");
            Klienci klienci = klienciDAO.get(id);
            mav.addObject("klienci", klienci);
            return mav;
        }
        @RequestMapping(value = "/update/klienci", method = RequestMethod.POST)
        public String updateKlienci(@ModelAttribute("klienci") Klienci klienci, Authentication authentication) {
            klienciDAO.update(klienci);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
        @RequestMapping("/edit/pracownicy/{id}")
        public ModelAndView showEditPracownicyForm(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("edit_forms/edit_pracownicy");
            Pracownicy pracownicy = pracownicyDAO.get(id);
            mav.addObject("pracownicy", pracownicy);
            return mav;
        }
        @RequestMapping(value = "/update/pracownicy", method = RequestMethod.POST)
        public String updatePracownicy(@ModelAttribute("pracownicy") Pracownicy pracownicy, Authentication authentication) {
            pracownicyDAO.update(pracownicy);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
        @RequestMapping("/edit/producenci/{id}")
        public ModelAndView showEditProducenciForm(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("edit_forms/edit_producenci");
            Producenci_telewizyjno_radiowi producenci_telewizyjno_radiowi = producenci_telewizyjno_radiowiDAO.get(id);
            mav.addObject("producenci_telewizyjno_radiowi", producenci_telewizyjno_radiowi);
            return mav;
        }
        @RequestMapping(value = "/update/producenci", method = RequestMethod.POST)
        public String updateProducenci(@ModelAttribute("producenci_telewizyjno_radiowi") Producenci_telewizyjno_radiowi producenci_telewizyjno_radiowi, Authentication authentication) {
            producenci_telewizyjno_radiowiDAO.update(producenci_telewizyjno_radiowi);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
        @RequestMapping("/edit/reklamy/{id}")
        public ModelAndView showEditReklamyForm(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("edit_forms/edit_reklamy");
            Reklamy reklamy = reklamyDAO.get(id);
            mav.addObject("reklamy", reklamy);
            return mav;
        }
        @RequestMapping(value = "/update/reklamy", method = RequestMethod.POST)
        public String updateReklamy(@ModelAttribute("reklamy") Reklamy reklamy, Authentication authentication) {
            reklamyDAO.update(reklamy);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
        @RequestMapping("/edit/stacje/{id}")
        public ModelAndView showEditStacjeForm(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("edit_forms/edit_stacje");
            Stacje stacje = stacjeDAO.get(id);
            mav.addObject("stacje", stacje);
            return mav;
        }
        @RequestMapping(value = "/update/stacje", method = RequestMethod.POST)
        public String updateStacje(@ModelAttribute("stacje") Stacje stacje, Authentication authentication) {
            stacjeDAO.update(stacje);
            String redirectPath = RedirectService.getRedirectPath(authentication);
            return "redirect:/data_" + redirectPath;
        }
    }

    @Controller
    public class DeleteController{
        @RequestMapping("/delete/klienci/{id}")
        public String deleteKlienci(@PathVariable(name = "id") int id) {
            klienciDAO.delete(id);
            return "redirect:/data_admin";
        }
        @RequestMapping("/delete/pracownicy/{id}")
        public String deletePracownicy(@PathVariable(name = "id") int id) {
            pracownicyDAO.delete(id);
            return "redirect:/data_admin";
        }
        @RequestMapping("/delete/producenci/{id}")
        public String deleteProducenci(@PathVariable(name = "id") int id) {
            producenci_telewizyjno_radiowiDAO.delete(id);
            return "redirect:/data_admin";
        }
        @RequestMapping("/delete/reklamy/{id}")
        public String deleteReklamy(@PathVariable(name = "id") int id) {
            reklamyDAO.delete(id);
            return "redirect:/data_admin";
        }
        @RequestMapping("/delete/stacje/{id}")
        public String deleteStacje(@PathVariable(name = "id") int id) {
            stacjeDAO.delete(id);
            return "redirect:/data_admin";
        }
    }

    @Autowired
    private PracownicyDAO pracownicyDAO;
    @Autowired
    private KlienciDAO klienciDAO;
    @Autowired
    private Producenci_telewizyjno_radiowiDAO producenci_telewizyjno_radiowiDAO;
    @Autowired
    private ReklamyDAO reklamyDAO;
    @Autowired
    private StacjeDAO stacjeDAO;




}