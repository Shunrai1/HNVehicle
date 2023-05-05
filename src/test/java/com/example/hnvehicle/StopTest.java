package com.example.hnvehicle;

import com.example.hnvehicle.bean.Stop;
import com.example.hnvehicle.service.StopService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/4/24 14:16
 * @Version 1.0
 * @Description
 */
@SpringBootTest
public class StopTest {
    @Resource
    StopService stopService;

    @Test
    public void addTest(){
        Stop stop = new Stop();
        stop.setLocality("2343.234 434.235;234.23 113.344");
        boolean save = stopService.save(stop);
        if(save){
            System.out.println( "添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void deleteTest(){
        boolean b = stopService.removeById(57);
        if (b){
            System.out.println("删除成功");

        }else {
            System.out.println("删除成功");

        }
    }

    @Test
    public void getAllTest(){
        List<Stop> list = stopService.list();
        for (Stop stop : list) {
            System.out.println(stop);
        }
    }

}
