package org.FIR.web;

import org.FIR.dao.FIRGameRecordDao;
import org.FIR.dao.FIRGameUserDao;
import org.FIR.entity.FIRGameRecord;
import org.FIR.entity.FIRGameUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tianyi
 * @date 2017-12-31 18:10
 */
@Controller//@Service @Component
@RequestMapping("/woaiguangzhongyi")//url:模块/资源/{id}/细分
public class FIRGmaeController {

    @Resource
    private FIRGameUserDao firGameUserDao;
    @Resource
    private FIRGameRecordDao firGameRecordDao;

    /*@RequestMapping(value = "/{userId}/record")
    public String toRecordPage(@PathVariable("userId")Long userId, Model model){
        if(userId==null){
            return "redirect:/This player is not exist.";
        }
        List<FIRGameRecord> firGameRecordList=firGameRecordDao.queryById(userId);
        if(firGameRecordList.isEmpty()){
            return "forward:/This player has no record to view.";
        }
        model.addAttribute("firGameRecordList",firGameRecordList);
        return "TESTrecordPage";
    }*/

    @RequestMapping(value = "/{userId}/record")
    public String toRecordPage(@PathVariable("userId")Long userId, Model model){
        if(userId==null){
            return "redirect:/This player is not exist.";
        }
        List<FIRGameRecord> firGameRecordList=firGameRecordDao.JOINWINqueryById(userId);
        if(firGameRecordList.isEmpty()){
            return "forward:/This player has no record to view.";
        }
        model.addAttribute("firGameRecordList",firGameRecordList);
        return "TESTrecordPage";
    }


    @RequestMapping(value = "/{roomId}/{userId1}/{userId2}/{root}/game")
    public String toGamePage(@PathVariable("roomId")int roomId, @PathVariable("userId1")Long userId1, @PathVariable("root")Long rootId, @PathVariable("userId2")Long userId2, Model model){
        if(firGameUserDao.queryById(userId1)==null||firGameUserDao.queryById(userId2)==null){
            return "redirect:../../index";
        }
        FIRGameUser firGameUser1=firGameUserDao.queryById(userId1);
        FIRGameUser firGameUser2=firGameUserDao.queryById(userId2);
        model.addAttribute("firGameUserA",firGameUser1);
        model.addAttribute("firGameUserB",firGameUser2);
        model.addAttribute("rootId",rootId);
        model.addAttribute("roomId",roomId);
        model.addAttribute("blackId",userId1);
        return "rooms/gamePage"+roomId;
    }

    @RequestMapping(value = "/{userName}/{password}/centre")
    public String toIndexPage(@PathVariable("userName")String userName,@PathVariable("password")String password, Model model){
        long id=firGameUserDao.getId(userName);
        if(id==0){
            return "redirect:../../index";
        }
        if(!firGameUserDao.getPassword(userName).equals(password)){
            System.out.println(firGameUserDao.getPassword(userName));
            return "forward:../../index";
        }
        FIRGameUser firGameUser=firGameUserDao.queryById(id);
        List<FIRGameUser> firGameUserList = firGameUserDao.queryAll(0,10);
        model.addAttribute("firGameUser",firGameUser);
        model.addAttribute("firGameUserList",firGameUserList);
        return "centre";
    }

    @RequestMapping(value = "/{userName}/{password}/testSort")
    public String testSort(@PathVariable("userName")String userName,@PathVariable("password")String password, Model model){
        long id=firGameUserDao.getId(userName);
        if(id==0){
            return "redirect:../../index";
        }
        if(!firGameUserDao.getPassword(userName).equals(password)){
            System.out.println(firGameUserDao.getPassword(userName));
            return "forward:../../index";
        }
        FIRGameUser firGameUser=firGameUserDao.queryById(id);
        List<FIRGameUser> firGameUserList = firGameUserDao.queryAll(0,10);
        model.addAttribute("firGameUser",firGameUser);
        model.addAttribute("firGameUserList",firGameUserList);
        return "testSort";
    }


    @RequestMapping(value = "/TEST")
    public String testSort(Model model){
        List<FIRGameRecord> firGameRecordList=firGameRecordDao.queryById(16);
        model.addAttribute("firGameRecordList",firGameRecordList);
        return "rooms/TESTgamePage";
    }
}
