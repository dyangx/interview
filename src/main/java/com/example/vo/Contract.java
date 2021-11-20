package com.example.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * 功能描述:
 *
 * @Author: yang jie
 * @Date: 2021/11/20 16:25
 */
@Data
public class Contract {

    @Excel(name = "合同编号")
    private String contractNo;

    @Excel(name = "合同名称")
    private String contractName;

    @Excel(name = "客户全称")
    private String customerName;

    @Excel(name = "客户签约主体")
    private String customerSign;

    @Excel(name = "合同文件名称")
    private String contractFileName;

    @Excel(name = "合同文件下载地址url")
    private String contractFilePath;

    public Contract() {
    }

    public Contract(String contractNo, String contractName, String customerName, String customerSign, String contractFileName, String contractFilePath) {
        this.contractNo = contractNo;
        this.contractName = contractName;
        this.customerName = customerName;
        this.customerSign = customerSign;
        this.contractFileName = contractFileName;
        this.contractFilePath = contractFilePath;
    }
}
