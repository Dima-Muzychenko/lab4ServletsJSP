package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Examination", catalog = "Driver")
public class ExaminationEntity {
    @Id
    @Column(name = "examination_id")
    private String examinationId;
    @Basic
    @Column(name = "category_A1")
    private boolean categoryA1;
    @Basic
    @Column(name = "category_A")
    private boolean categoryA;
    @Basic
    @Column(name = "category_B1")
    private boolean categoryB1;
    @Basic
    @Column(name = "category_B")
    private boolean categoryB;
    @Basic
    @Column(name = "category_C1")
    private boolean categoryC1;
    @Basic
    @Column(name = "category_C")
    private boolean categoryC;
    @Basic
    @Column(name = "category_D1")
    private boolean categoryD1;
    @Basic
    @Column(name = "category_D")
    private boolean categoryD;
    @Basic
    @Column(name = "category_C1E")
    private boolean categoryC1E;
    @Basic
    @Column(name = "category_BE")
    private boolean categoryBe;
    @Basic
    @Column(name = "category_CE")
    private boolean categoryCe;
    @Basic
    @Column(name = "category_D1E")
    private boolean categoryD1E;
    @Basic
    @Column(name = "category_DE")
    private boolean categoryDe;
    @Basic
    @Column(name = "category_T1")
    private boolean categoryT1;
    @Basic
    @Column(name = "category_T2")
    private boolean categoryT2;
    @Basic
    @Column(name = "passed_category")
    private String passedCategory;
    @ManyToOne
    @JoinColumn(name = "pasport_id", referencedColumnName = "passport_id", nullable = false)
    private DriverEntity driverByPasportId;
    @ManyToOne
    @JoinColumn(name = "Ministry_of_Internal_Affairs_id", referencedColumnName = "MIA_id", nullable = false)
    private MIAEntity miaByMinistryOfInternalAffairsId;


    public String getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(String examinationId) {
        this.examinationId = examinationId;
    }


    public boolean isCategoryA1() {
        return categoryA1;
    }

    public void setCategoryA1(boolean categoryA1) {
        this.categoryA1 = categoryA1;
    }


    public boolean isCategoryA() {
        return categoryA;
    }

    public void setCategoryA(boolean categoryA) {
        this.categoryA = categoryA;
    }


    public boolean isCategoryB1() {
        return categoryB1;
    }

    public void setCategoryB1(boolean categoryB1) {
        this.categoryB1 = categoryB1;
    }


    public boolean isCategoryB() {
        return categoryB;
    }

    public void setCategoryB(boolean categoryB) {
        this.categoryB = categoryB;
    }


    public boolean isCategoryC1() {
        return categoryC1;
    }

    public void setCategoryC1(boolean categoryC1) {
        this.categoryC1 = categoryC1;
    }


    public boolean isCategoryC() {
        return categoryC;
    }

    public void setCategoryC(boolean categoryC) {
        this.categoryC = categoryC;
    }


    public boolean isCategoryD1() {
        return categoryD1;
    }

    public void setCategoryD1(boolean categoryD1) {
        this.categoryD1 = categoryD1;
    }


    public boolean isCategoryD() {
        return categoryD;
    }

    public void setCategoryD(boolean categoryD) {
        this.categoryD = categoryD;
    }


    public boolean isCategoryC1E() {
        return categoryC1E;
    }

    public void setCategoryC1E(boolean categoryC1E) {
        this.categoryC1E = categoryC1E;
    }


    public boolean isCategoryBe() {
        return categoryBe;
    }

    public void setCategoryBe(boolean categoryBe) {
        this.categoryBe = categoryBe;
    }


    public boolean isCategoryCe() {
        return categoryCe;
    }

    public void setCategoryCe(boolean categoryCe) {
        this.categoryCe = categoryCe;
    }


    public boolean isCategoryD1E() {
        return categoryD1E;
    }

    public void setCategoryD1E(boolean categoryD1E) {
        this.categoryD1E = categoryD1E;
    }


    public boolean isCategoryDe() {
        return categoryDe;
    }

    public void setCategoryDe(boolean categoryDe) {
        this.categoryDe = categoryDe;
    }


    public boolean isCategoryT1() {
        return categoryT1;
    }

    public void setCategoryT1(boolean categoryT1) {
        this.categoryT1 = categoryT1;
    }


    public boolean isCategoryT2() {
        return categoryT2;
    }

    public void setCategoryT2(boolean categoryT2) {
        this.categoryT2 = categoryT2;
    }


    public String getPassedCategory() {
        return passedCategory;
    }

    public void setPassedCategory(String passedCategory) {
        this.passedCategory = passedCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminationEntity that = (ExaminationEntity) o;
        return categoryA1 == that.categoryA1 && categoryA == that.categoryA && categoryB1 == that.categoryB1 && categoryB == that.categoryB && categoryC1 == that.categoryC1 && categoryC == that.categoryC && categoryD1 == that.categoryD1 && categoryD == that.categoryD && categoryC1E == that.categoryC1E && categoryBe == that.categoryBe && categoryCe == that.categoryCe && categoryD1E == that.categoryD1E && categoryDe == that.categoryDe && categoryT1 == that.categoryT1 && categoryT2 == that.categoryT2 && Objects.equals(examinationId, that.examinationId)  && Objects.equals(passedCategory, that.passedCategory);
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ExaminationEntity that = (ExaminationEntity) o;
//        return categoryA1 == that.categoryA1 && categoryA == that.categoryA && categoryB1 == that.categoryB1 && categoryB == that.categoryB && categoryC1 == that.categoryC1 && categoryC == that.categoryC && categoryD1 == that.categoryD1 && categoryD == that.categoryD && categoryC1E == that.categoryC1E && categoryBe == that.categoryBe && categoryCe == that.categoryCe && categoryD1E == that.categoryD1E && categoryDe == that.categoryDe && categoryT1 == that.categoryT1 && categoryT2 == that.categoryT2 && Objects.equals(examinationId, that.examinationId) && Objects.equals(pasportId, that.pasportId) && Objects.equals(ministryOfInternalAffairsId, that.ministryOfInternalAffairsId) && Objects.equals(passedCategory, that.passedCategory);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(examinationId, categoryA1, categoryA, categoryB1, categoryB, categoryC1, categoryC, categoryD1, categoryD, categoryC1E, categoryBe, categoryCe, categoryD1E, categoryDe, categoryT1, categoryT2, passedCategory);
    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(examinationId, pasportId, ministryOfInternalAffairsId, categoryA1, categoryA, categoryB1, categoryB, categoryC1, categoryC, categoryD1, categoryD, categoryC1E, categoryBe, categoryCe, categoryD1E, categoryDe, categoryT1, categoryT2, passedCategory);
//    }


    public DriverEntity getDriverByPasportId() {
        return driverByPasportId;
    }

    public void setDriverByPasportId(DriverEntity driverByPasportId) {
        this.driverByPasportId = driverByPasportId;
    }

    public MIAEntity getMiaByMinistryOfInternalAffairsId() {
        return miaByMinistryOfInternalAffairsId;
    }

    public void setMiaByMinistryOfInternalAffairsId(MIAEntity miaByMinistryOfInternalAffairsId) {
        this.miaByMinistryOfInternalAffairsId = miaByMinistryOfInternalAffairsId;
    }
    public static Object[] getTableTitles(){
        Object[] columns = new Object[19];
        columns[0]="examination_Id";
        columns[1]="Category_A1";
        columns[2]="Category_A";
        columns[3]="Category_B1";
        columns[4]="Category_B";
        columns[5]="Category_C1";
        columns[6]="Category_C";
        columns[7]="Category_D1";
        columns[8]="Category_D";
        columns[9]="Category_C1E";
        columns[10]="Category_BE";
        columns[11]="Category_CE";
        columns[12]="Category_D1E";
        columns[13]="Category_DE";
        columns[14]="Category_T1";
        columns[15]="Category_T2";
        columns[16]="passed_category";
        columns[17]="pasport_id";
        columns[18]="MIA id";
        return columns;
    }

    public static Object[] getTableTitlesForDelete(){
        Object[] columns = new Object[4];
        columns[0]="examinationId";
        columns[1]="passedCategory";
        columns[2]="driverByPasportId";
        columns[3]="miaByMinistryOfInternalAffairsId";
        return columns;
    }
    public static Object[] getSelected(Object obj){
        ExaminationEntity zm=(ExaminationEntity) obj;
        Object[] objInfo = new String[19];
        objInfo[0]=String.valueOf(zm.getExaminationId());
        objInfo[1]=String.valueOf(zm.isCategoryA1());
        objInfo[2]=String.valueOf(zm.isCategoryA());
        objInfo[3]=String.valueOf(zm.isCategoryB1());
        objInfo[4]=String.valueOf(zm.isCategoryB());
        objInfo[5]=String.valueOf(zm.isCategoryC1());
        objInfo[6]=String.valueOf(zm.isCategoryC());
        objInfo[7]=String.valueOf(zm.isCategoryD1());
        objInfo[8]=String.valueOf(zm.isCategoryD());
        objInfo[9]=String.valueOf(zm.isCategoryC1E());
        objInfo[10]=String.valueOf(zm.isCategoryBe());
        objInfo[11]=String.valueOf(zm.isCategoryCe());
        objInfo[12]=String.valueOf(zm.isCategoryD1E());
        objInfo[13]=String.valueOf(zm.isCategoryDe());
        objInfo[14]=String.valueOf(zm.isCategoryT1());
        objInfo[15]=String.valueOf(zm.isCategoryT2());
        objInfo[16]=String.valueOf(zm.getPassedCategory());
        objInfo[17]=String.valueOf(zm.getDriverByPasportId().getPasportId());
        objInfo[18]=String.valueOf(zm.getMiaByMinistryOfInternalAffairsId().getMiaId());
        return objInfo;
    }

    public static Object[] getSelectPublicInfo(Object obj){//поля для зміни
        ExaminationEntity zm=(ExaminationEntity) obj;
        Object[] objInfo = new String[18];
        objInfo[0]=String.valueOf(zm.isCategoryA1());
        objInfo[1]=String.valueOf(zm.isCategoryA());
        objInfo[2]=String.valueOf(zm.isCategoryB1());
        objInfo[3]=String.valueOf(zm.isCategoryB());
        objInfo[4]=String.valueOf(zm.isCategoryC1());
        objInfo[5]=String.valueOf(zm.isCategoryC());
        objInfo[6]=String.valueOf(zm.isCategoryD1());
        objInfo[7]=String.valueOf(zm.isCategoryD());
        objInfo[8]=String.valueOf(zm.isCategoryC1E());
        objInfo[9]=String.valueOf(zm.isCategoryBe());
        objInfo[10]=String.valueOf(zm.isCategoryCe());
        objInfo[11]=String.valueOf(zm.isCategoryD1E());
        objInfo[12]=String.valueOf(zm.isCategoryDe());
        objInfo[13]=String.valueOf(zm.isCategoryT1());
        objInfo[14]=String.valueOf(zm.isCategoryT2());
        objInfo[15]=String.valueOf(zm.getPassedCategory());
        objInfo[16]=String.valueOf(zm.getDriverByPasportId().getPasportId());
        objInfo[17]=String.valueOf(zm.getMiaByMinistryOfInternalAffairsId().getMiaId());
        return objInfo;
    }
}
