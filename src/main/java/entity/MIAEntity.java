package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MIA", catalog = "Driver")
public class MIAEntity {
    @Id
    @Column(name = "MIA_id")
    private String miaId;
    @Basic
    @Column(name = "address")
    private String address;


    public String getMiaId() {
        return miaId;
    }

    public void setMiaId(String miaId) {
        this.miaId = miaId;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MIAEntity miaEntity = (MIAEntity) o;
        return Objects.equals(miaId, miaEntity.miaId) && Objects.equals(address, miaEntity.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(miaId, address);
    }

    public static Object[] getTableTitles(){
        Object[] columns = new Object[2];
        columns[0]="miaId";
        columns[1]="address";
        return columns;
    }

    public static Object[] getTableTitlesForDelete(){
        Object[] columns = new Object[2];
        columns[0]="miaId";
        columns[1]="address";
        return columns;
    }

    public static Object[] getSelected(Object obj){
        MIAEntity zm=(MIAEntity) obj;
        Object[] objInfo = new String[2];
        objInfo[0]=String.valueOf(zm.getMiaId());
        objInfo[1]=String.valueOf(zm.getAddress());
        return objInfo;
    }
    public static Object[] getSelectPublicInfo(Object obj){//поля для зміни
        MIAEntity zm=(MIAEntity) obj;
        Object[] objInfo = new String[1];
        objInfo[0]=String.valueOf(zm.getAddress());
        return objInfo;
    }
}
