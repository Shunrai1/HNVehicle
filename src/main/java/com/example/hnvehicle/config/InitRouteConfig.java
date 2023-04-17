package com.example.hnvehicle.config;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import com.graphhopper.util.*;
import com.graphhopper.util.shapes.GHPoint3D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.RouteMatcher;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @Author Shunrai
 * @Date 2023/4/15 13:43
 * @Version 1.0
 * @Description
 */
@Configuration
@Component
public class InitRouteConfig {
//
//    private static final Logger logger = LoggerFactory.getLogger(InitJDBCConnectionConfig.class);
//
//    @Resource
//    private SystemConfigMapper systemConfigMapper;


    public static void main(String[] args) {
        new InitRouteConfig().initConnection();
    }
    @Bean
    public GraphHopper initConnection() {
//        logger.info("-------开始初始化路径规划服务数据！-----------");
        GraphHopper  hopper = new GraphHopper();
        // OSM 文件路径
//        List<SystemConfig> systemConfigList = systemConfigMapper.selectByExample(new SystemConfigExample());
//        if (systemConfigList.size() > 0) {
            String routeFilePath = "D:\\大学课程资料\\openstreet数据";
            File fileT = new File(routeFilePath+"\\HNmap.osm");
            if (fileT.exists()) {
                hopper.setOSMFile(routeFilePath+"\\HNmap.osm");
                // 读取完OSM数据之后会构建路线图，此处配置图的存储路径
                hopper.setGraphHopperLocation(routeFilePath);
                // 目前免费包仅支持car、bike、foot三种交通方式的导航
                List<Profile> profiles = new ArrayList<>();
                // 目前提供三种出行方式 驾车 骑行 步行 优先返回最快路线 不考虑经济成本
                profiles.add(new Profile("car").setVehicle("car").setWeighting("fastest").setTurnCosts(false));
                profiles.add(new Profile("bike").setVehicle("bike").setWeighting("fastest").setTurnCosts(false));
                profiles.add(new Profile("foot").setVehicle("foot").setWeighting("fastest").setTurnCosts(false));
                hopper.setProfiles(profiles);
                // 开启速度模式
//        hopper.getCHPreparationHandler().setCHProfiles(new CHProfile("car"));
                // 导入过程可能需要几分钟，加载可能需要几秒钟，取决于导入的区域数据大小
                hopper.importOrLoad();
                System.out.println("-------初始化路径规划服务数据完成！-----------");
            } else {
                System.out.println("-------初始化路径规划服务数据失败！未检查到route.osm文件-----------");
            }
//        }
//        else{
//            logger.info("-------初始化路径规划服务数据失败！请检查系统配置临时文件存放路径是否正确！-----------");
//        }
        return hopper;
    }

    public static void routing(GraphHopper hopper) {
        // 配置一个简单的请求
        GHRequest req = new GHRequest(42.508552, 1.532936, 42.507508, 1.528773).
                // 注意，即使只有这样一个配置文件，我们也必须指定要使用的配置文件
                        setProfile("car").
                // 定义转弯指令的语言
                        setLocale(Locale.CHINA);

        // 设置返回最多备用路线3条
        req.getHints().putObject(Parameters.Algorithms.AltRoute.MAX_PATHS, 3);
        // 设置无法通行区域
        req.putHint(Parameters.Routing.BLOCK_AREA, "纬度,经度,纬度,经度");

        GHResponse rsp = hopper.route(req);

        // 报错处理
        if (rsp.hasErrors()) {
            throw new RuntimeException(rsp.getErrors().toString());
        }

        // 使用最佳路径，请参阅GHResponse类以了解更多可能性。
        ResponsePath path = rsp.getBest();

        // 全路径的点、距离（米）和时间（毫秒）
        PointList pointList = path.getPoints();
        double distance = path.getDistance();
        long timeInMs = path.getTime();

        Translation tr = hopper.getTranslationMap().getWithFallBack(Locale.UK);
        InstructionList il = path.getInstructions();
        // 迭代所有turn指令
        for (Instruction instruction : il) {
            // System.out.println("distance " + instruction.getDistance() + " for instruction: " + instruction.getTurnDescription(tr));
        }
        assert il.size() == 6;
        assert Helper.round(path.getDistance(), -2) == 900;
    }

}
