package com.example.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: yangjie
 * @date: Created in 2020/5/6 16:50
 */
public class TestMe {

    public static void main(String[] args) {
        System.out.println(System.getProperty("dir"));
        System.out.println(TestMe.class.getClassLoader().getResource("tester.xml").getPath());

        String s = "\"[{\\\"cst\\\":{\\\"createBy\\\":\\\"李谭\\\",\\\"createTime\\\":1585142114000,\\\"cstAlias\\\":\\\"创可贴123\\\",\\\"cstCode\\\":\\\"C000018-10002\\\",\\\"cstId\\\":\\\"40288a107107490c01710f2700f200d4\\\",\\\"cstModel\\\":\\\"xh-103\\\",\\\"cstName\\\":\\\"医用创可贴\\\",\\\"cstSpec\\\":\\\"gg-103\\\",\\\"cstType\\\":\\\"0\\\",\\\"destroyMethod\\\":\\\"4\\\",\\\"hospId\\\":\\\"4028829767e2f5960167e3550aa500cb\\\",\\\"inPrice\\\":7.79,\\\"manuName\\\":\\\"厂家103\\\",\\\"outPrice\\\":7.79,\\\"qualityMonth\\\":120,\\\"regNo\\\":\\\"ckt00000000000000000000000000103\\\",\\\"remark\\\":\\\"备注信息\\\",\\\"status\\\":\\\"1\\\",\\\"udiCode\\\":\\\"UDI00000000103\\\",\\\"unit\\\":\\\"盒\\\",\\\"updateTime\\\":1585142114000,\\\"valueType\\\":\\\"1\\\",\\\"vendorId\\\":\\\"40288a107107490c01710a3afc82000e\\\",\\\"vendorName\\\":\\\"阜外医疗器械有限公司\\\",\\\"verifyReason\\\":\\\"审核通过\\\",\\\"verifyStatus\\\":\\\"1\\\"},\\\"fee\\\":{\\\"createId\\\":\\\"10000000000000000000000000000001\\\",\\\"createName\\\":\\\"系统管理员\\\",\\\"createTime\\\":1589001122317,\\\"deptId\\\":\\\"9cb10bf4d55d21d4f792f0b48bf6bdaf\\\",\\\"deviceId\\\":\\\"e0553fcc0ebcda2cdfa0f69bde20308a\\\",\\\"deviceName\\\":\\\"阜外科室1\\\",\\\"feeId\\\":\\\"eea6732b809bd8a3b041815ea3f3b312\\\",\\\"feeType\\\":\\\"0\\\",\\\"inventoryId\\\":\\\"40288a1071295f3101713487b59b02ea\\\",\\\"inventoryPreStatus\\\":\\\"3\\\",\\\"patientIndexId\\\":\\\"c284424e37ef8a220ff704b73a044bea\\\",\\\"status\\\":\\\"0\\\",\\\"sthId\\\":\\\"0d2b11a75c7736a34a0d2e44f6e44dc2\\\",\\\"systemType\\\":\\\"HCT\\\",\\\"updateFeeStatus\\\":false,\\\"updateId\\\":\\\"10000000000000000000000000000001\\\",\\\"updateName\\\":\\\"系统管理员\\\",\\\"updateTime\\\":1589001122317},\\\"inventory\\\":{\\\"barcode\\\":\\\"887\\\",\\\"batchNo\\\":\\\"403\\\",\\\"billStatus\\\":\\\"0\\\",\\\"createTime\\\":1585724241000,\\\"creator\\\":\\\"李谭\\\",\\\"cstId\\\":\\\"40288a107107490c01710f2700f200d4\\\",\\\"deleteCount\\\":0,\\\"deliverNo\\\":\\\"000018-FH2004011003\\\",\\\"deptId\\\":\\\"9cb10bf4d55d21d4f792f0b48bf6bdaf\\\",\\\"deptName\\\":\\\"阜外科室1\\\",\\\"deviceCode\\\":\\\"1\\\",\\\"deviceId\\\":\\\"e0553fcc0ebcda2cdfa0f69bde20308a\\\",\\\"deviceName\\\":\\\"成都is\\\",\\\"epc\\\":\\\"827703000030191216002887\\\",\\\"epcCode\\\":\\\"RIVA000018128\\\",\\\"expiryDate\\\":1601395200000,\\\"hisPatientId\\\":\\\"\\\",\\\"inPrice\\\":7.79,\\\"inventoryId\\\":\\\"40288a1071295f3101713487b59b02ea\\\",\\\"isConfirmUsed\\\":0,\\\"isPrint\\\":\\\"1\\\",\\\"patientIndexId\\\":\\\"ecb816a1dd9eeeff1c4f254d85d0b0a7\\\",\\\"patientName\\\":\\\"tyy\\\",\\\"printFreq\\\":1,\\\"produceDate\\\":1585670400000,\\\"status\\\":\\\"19\\\",\\\"sthCstId\\\":\\\"68d418a6b3248be9df57d3c872d6568b\\\",\\\"sthId\\\":\\\"0d2b11a75c7736a34a0d2e44f6e44dc2\\\",\\\"sthLevel\\\":\\\"2\\\",\\\"sthName\\\":\\\"阜外库房1\\\",\\\"stockNum\\\":1,\\\"systemType\\\":\\\"HCT\\\",\\\"targetSthId\\\":\\\"0d2b11a75c7736a34a0d2e44f6e44dc2\\\",\\\"targetSthName\\\":\\\"阜外库房1\\\",\\\"thingId\\\":\\\"9c5e12abd3270731ff917aea2087eae2\\\",\\\"unit\\\":\\\"盒\\\",\\\"updateId\\\":\\\"3d74d55033e010098830f8a1989308f3\\\",\\\"updateTime\\\":1589001048000,\\\"updator\\\":\\\"李谭\\\",\\\"updatorName\\\":\\\"李谭\\\",\\\"vendorId\\\":\\\"40288a107107490c01710a3afc82000e\\\",\\\"waitInStoreNo\\\":\\\"123\\\",\\\"wholeUdi\\\":\\\"01UDI000000001031720083110403\\\"},\\\"patient\\\":{\\\"address\\\":\\\"患者详细住址\\\",\\\"bedNo\\\":\\\"1051\\\",\\\"birthday\\\":1586966400000,\\\"caseNo\\\":\\\"41522\\\",\\\"chargeType\\\":\\\"1\\\",\\\"chiefDoctor\\\":\\\"张医生\\\",\\\"createTime\\\":1589001122317,\\\"doctorName\\\":\\\"患者101医生\\\",\\\"gender\\\":\\\"女\\\",\\\"hisDoctorId\\\":\\\"3211\\\",\\\"hisPatientId\\\":\\\"1051021512\\\",\\\"hisScheduleId\\\":\\\"105112\\\",\\\"idCard\\\":\\\"510113199909272022\\\",\\\"medicalDeptId\\\":\\\"9cb10bf4d55d21d4f792f0b48bf6bdaf\\\",\\\"medicalId\\\":\\\"7b607c96-65cf-4326-bd7b-e04127\\\",\\\"optRoomId\\\":\\\"b3638066-7762-4bff-8b6b-74362d\\\",\\\"optRoomName\\\":\\\"阜外手术间01\\\",\\\"optRoomNo\\\":\\\"fuwai01\\\",\\\"optRoomPym\\\":\\\"haha\\\",\\\"patientId\\\":\\\"3a53a36f-0762-45e1-b0c4-622442\\\",\\\"patientIndexId\\\":\\\"ecb816a1dd9eeeff1c4f254d85d0b0a7\\\",\\\"patientName\\\":\\\"卡森桌\\\",\\\"patientPym\\\":\\\"ksz\\\",\\\"patientType\\\":\\\"3\\\",\\\"scheduleTime\\\":1588908026000,\\\"surgeryDeptId\\\":\\\"9cb10bf4d55d21d4f792f0b48bf6bdaf\\\",\\\"surgeryDeptName\\\":\\\"阜外科室1\\\",\\\"surgeryId\\\":\\\"42c75376fb883c379a7047f1586ffed2\\\",\\\"surgeryName\\\":\\\"手术名105\\\",\\\"updateTime\\\":1589001122317,\\\"visitTime\\\":1588664373000}}]\"";
        JSONObject o = JSONObject.parseObject(s);
        System.out.println(o);
    }
}
