package entity;

import javax.persistence.*;

@Entity
//@Table(name = "Auto_courses", schema = "public", catalog = "Driver")
@Table(name="Auto_courses", schema = "public",catalog="Driver")
public class AutoCoursesEntity {
    @Id
    @Column(name = "institution_code")
    private String institutionCode;
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
    @Column(name = "courses_name")
    private String coursesName;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "teacher_full_name")
    private String teacherFullName;

    public AutoCoursesEntity(){}

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
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


    public String getCoursesName() {
        return coursesName;
    }

    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getTeacherFullName() {
        return teacherFullName;
    }

    public void setTeacherFullName(String teacherFullName) {
        this.teacherFullName = teacherFullName;
    }

    public static Object[] getTableTitles(){//список полів (вик. для найменування таблиць при воводі)
        Object[] columns = new Object[19];
        columns[0]="Institution_code";
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
        columns[16]="courses_name";
        columns[17]="address";
        columns[18]="teacher_full_name";
        return columns;
    }
    public static Object[] getTableTitlesForDelete(){//список полів, по яким можна вибирати елементи для видалення
        Object[] columns = new Object[4];
        columns[0]="institutionCode";//потрібно саме ім'я змінної
        columns[1]="coursesName";
        columns[2]="address";
        columns[3]="teacherFullName";
        return columns;
    }

    public static Object[] getSelected(Object obj){//повна інфа
        AutoCoursesEntity zm=(AutoCoursesEntity) obj;
        Object[] objInfo = new String[19];
        objInfo[0]=String.valueOf(zm.getInstitutionCode());
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
        objInfo[11]=String.valueOf(zm.isCategoryC1E());
        objInfo[12]=String.valueOf(zm.isCategoryD1E());
        objInfo[13]=String.valueOf(zm.isCategoryD1E());
        objInfo[14]=String.valueOf(zm.isCategoryT1());
        objInfo[15]=String.valueOf(zm.isCategoryT2());
        objInfo[16]=String.valueOf(zm.getCoursesName());
        objInfo[17]=String.valueOf(zm.getAddress());
        objInfo[18]=String.valueOf(zm.getTeacherFullName());
        return objInfo;
    }
    public static Object[] getSelectPublicInfo(Object obj){//поля для зміни
        AutoCoursesEntity zm=(AutoCoursesEntity) obj;
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
        objInfo[10]=String.valueOf(zm.isCategoryC1E());
        objInfo[11]=String.valueOf(zm.isCategoryD1E());
        objInfo[12]=String.valueOf(zm.isCategoryD1E());
        objInfo[13]=String.valueOf(zm.isCategoryT1());
        objInfo[14]=String.valueOf(zm.isCategoryT2());
        objInfo[15]=String.valueOf(zm.getCoursesName());
        objInfo[16]=String.valueOf(zm.getAddress());
        objInfo[17]=String.valueOf(zm.getTeacherFullName());
        return objInfo;
    }
}
