package com.example.hnvehicle.utility;

import com.example.hnvehicle.config.InitRouteConfig;
import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.util.PointList;
import com.graphhopper.util.shapes.GHPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author Shunrai
 * @Date 2023/4/11 15:50
 * @Version 1.0
 * @Description
 */
public class GPSUtility {


    public static void main(String[] args) {

        GPSUtility gpsUtility = new GPSUtility();
        try {
            gpsUtility.generateTrackData("113.35948,23.159074;113.360349,23.159562;113.361052,23.159404", 30.0, 10.0, 0.0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject generateTrackData(String points, Double timeInterval, Double speed, Double randomBase) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("type","FeatureCollection");
        JSONArray features = new JSONArray();
        List<GHPoint> GHpoints = new ArrayList<>();
        String[] pointsz = points.split(";", -1);
        // 遍历同时检查点位 如果超出中国范围的点位直接处理掉
        for (int i = 0; i < pointsz.length; i++) {
            GHpoints.add(GHPoint.fromStringLonLat(pointsz[i]));
        }
        // 请求对象的简单配置
        GHRequest req = new GHRequest(GHpoints).setProfile("bike").setLocale(Locale.CHINA);
        // 获取返回结果
        InitRouteConfig initRouteConfig = new InitRouteConfig();
        GraphHopper graphHopper = initRouteConfig.initConnection();
        GHResponse rsp = graphHopper.route(req);
        // handle errors
        if (rsp.hasErrors()) {
            throw new RuntimeException(rsp.getErrors().toString());
        }
        // 获取返回的路线数据 然后根据路线生成对应轨迹点
        ResponsePath path = rsp.getBest();
        // 全路径的点、距离（米）和时间（毫秒）
        PointList routePointList = path.getPoints();
        //获取到总路线长度距离 单位米
        double routeDistance = path.getDistance();
        String routeWkt = routePointList.toLineString(true).toString();
        // 根据参数计算传入间隔时间每次行驶距离 单位米
        double distanceOneS = timeInterval * speed / 3600 * 1000;
        //获取到模拟生成的点位个数
        int pointCount = (int) Math.ceil(routeDistance / distanceOneS);
        double percent = 0.0;
        for(int i = 0;i <pointCount;i++){
            double dl = 1.0 / pointCount;
            Map<String, Object> feature = new HashMap<>();
            double bl = Math.random() * randomBase;
            if(Math.random()<0.5 && dl+(bl*-1) > 0 ){
                bl += bl*-1;
            }
            percent +=  dl + bl;
            if(percent <= 1){
                // 赋值 空间字段
                Map<String, Object> geometry = new HashMap<>();
                String sql = "SELECT ST_x(ST_LineInterpolatePoint(geom, " + percent + ")) as x,ST_y(ST_LineInterpolatePoint(geom, " + percent + ")) as y FROM (SELECT ST_GeomFromText('" + routeWkt + "',4326) as geom) As insert_point ;";
//                Map<String, Object> xy = jdbcTemplate.queryForMap(sql);
//                double lng = (double) xy.get("x");
//                double lat = (double) xy.get("y");
//                double[] location = new double[2];
//                location[0] = lng;
//                location[1] = lat;
//                geometry.put("type", "Point");
//                geometry.put("coordinates", location);
//                feature.put("geometry",geometry );
//                feature.put("type","Feature" );
//                features.add(feature);
            }
        }
        result.put("features",features);
        return result;
    }




}
