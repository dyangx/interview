package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName biz_product_shop
 */
@TableName(value ="biz_product_shop")
@Data
public class BizProductShop implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer bizproductid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String phonenumber;

    /**
     * 
     */
    private String latitude;

    /**
     * 
     */
    private String longitude;

    /**
     * 
     */
    private String memo;

    /**
     * 
     */
    private Integer scale;

    /**
     * 
     */
    private Integer sort;

    /**
     * 
     */
    private Date createdate;

    /**
     * customer_man_sys表id
     */
    private Integer customerid;

    /**
     * 省/市
     */
    private String province;

    /**
     * 市区

     */
    private String city;

    /**
     * 县级
     */
    private String county;

    /**
     * POI编号，关联biz_product_shop_poi表
     */
    private String poi;

    /**
     * 合同id
     */
    private Integer contractid;

    /**
     * biz_product_shop_poi表主键
     */
    private Integer shopid;

    /**
     * 是否展示 1:展示 0:隐藏
     */
    private Integer visible;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BizProductShop other = (BizProductShop) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBizproductid() == null ? other.getBizproductid() == null : this.getBizproductid().equals(other.getBizproductid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPhonenumber() == null ? other.getPhonenumber() == null : this.getPhonenumber().equals(other.getPhonenumber()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getScale() == null ? other.getScale() == null : this.getScale().equals(other.getScale()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getCustomerid() == null ? other.getCustomerid() == null : this.getCustomerid().equals(other.getCustomerid()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getPoi() == null ? other.getPoi() == null : this.getPoi().equals(other.getPoi()))
            && (this.getContractid() == null ? other.getContractid() == null : this.getContractid().equals(other.getContractid()))
            && (this.getShopid() == null ? other.getShopid() == null : this.getShopid().equals(other.getShopid()))
            && (this.getVisible() == null ? other.getVisible() == null : this.getVisible().equals(other.getVisible()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBizproductid() == null) ? 0 : getBizproductid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPhonenumber() == null) ? 0 : getPhonenumber().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getScale() == null) ? 0 : getScale().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getCustomerid() == null) ? 0 : getCustomerid().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getPoi() == null) ? 0 : getPoi().hashCode());
        result = prime * result + ((getContractid() == null) ? 0 : getContractid().hashCode());
        result = prime * result + ((getShopid() == null) ? 0 : getShopid().hashCode());
        result = prime * result + ((getVisible() == null) ? 0 : getVisible().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bizproductid=").append(bizproductid);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", memo=").append(memo);
        sb.append(", scale=").append(scale);
        sb.append(", sort=").append(sort);
        sb.append(", createdate=").append(createdate);
        sb.append(", customerid=").append(customerid);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", poi=").append(poi);
        sb.append(", contractid=").append(contractid);
        sb.append(", shopid=").append(shopid);
        sb.append(", visible=").append(visible);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}