package entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "Practice", catalog = "Driver")
public class PracticeEntity {
//    private String examinationId;
@Basic
@Column(name = "passed/unpassed")
    private boolean passedUnpassed;
    @Basic
    @Column(name = "left_attempts")
    private int leftAttempts;

    @Basic
    @Column(name = "used_attempts")
    private int usedAttempts;
    @Basic
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "examination_id", referencedColumnName = "examination_id", nullable = false)
    private ExaminationEntity examinationByExaminationId;

    @Id
    @Column(name = "number_of_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//перевірити, чи буде без цього працювати
    private int numberOfOrder;
    public int getNumberOfOrder() {
        return numberOfOrder;
    }
//    public void setNumberOfOrder(int numberOfOrder) {
//        this.numberOfOrder = numberOfOrder;
//    }


//    @Basic
//    @Column(name = "examination_id")
//    public String getExaminationId() {
//        return examinationId;
//    }
//
//    public void setExaminationId(String examinationId) {
//        this.examinationId = examinationId;
//    }


    public boolean isPassedUnpassed() {
        return passedUnpassed;
    }

    public void setPassedUnpassed(boolean passedUnpassed) {
        this.passedUnpassed = passedUnpassed;
    }


    public int getLeftAttempts() {
        return leftAttempts;
    }

    public void setLeftAttempts(int leftAttempts) {
        this.leftAttempts = leftAttempts;
    }


    public int getUsedAttempts() {
        return usedAttempts;
    }

    public void setUsedAttempts(int usedAttempts) {
        this.usedAttempts = usedAttempts;
    }


    public Date getDate() {
        return date;
    }

    public void setDate() {//дата в момент створення
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        this.date = Date.valueOf(dtf.format(now));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeEntity that = (PracticeEntity) o;
        return passedUnpassed == that.passedUnpassed && leftAttempts == that.leftAttempts && usedAttempts == that.usedAttempts && numberOfOrder == that.numberOfOrder  && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passedUnpassed, leftAttempts, usedAttempts, date, numberOfOrder);
    }



    public ExaminationEntity getExaminationByExaminationId() {
        return examinationByExaminationId;
    }

    public void setExaminationByExaminationId(ExaminationEntity examinationByExaminationId) {
        this.examinationByExaminationId = examinationByExaminationId;
    }

    public static Object[] getTableTitles(){
        Object[] columns = new Object[6];
        columns[0]="numberOfOrder";
        columns[1]="passedUnpassed";
        columns[2]="leftAttempts";//тут помилка
        columns[3]="usedAttempts";
        columns[4]="date";
        columns[5]="examinationByExaminationId";
        return columns;
    }

    public static Object[] getTableTitlesForDelete(){
        Object[] columns = new Object[5];
        columns[0]="numberOfOrder";
        columns[1]="leftAttempts";//тут помилка
        columns[2]="usedAttempts";
        columns[3]="date";
        columns[4]="examinationByExaminationId";
        return columns;
    }
    public static Object[] getSelected(Object obj){
        PracticeEntity zm=(PracticeEntity) obj;
        Object[] objInfo = new String[6];
        objInfo[0]=String.valueOf(zm.getNumberOfOrder());
        objInfo[1]=String.valueOf(zm.isPassedUnpassed());
        objInfo[2]=String.valueOf(zm.getLeftAttempts());
        objInfo[3]=String.valueOf(zm.getUsedAttempts());
        objInfo[4]=String.valueOf(zm.getDate());
        objInfo[5]=String.valueOf(zm.getExaminationByExaminationId().getExaminationId());
        return objInfo;
    }

    public static Object[] getSelectPublicInfo(Object obj){//поля для зміни
        PracticeEntity zm=(PracticeEntity) obj;
        Object[] objInfo = new String[5];
        objInfo[0]=String.valueOf(zm.isPassedUnpassed());
        objInfo[1]=String.valueOf(zm.getLeftAttempts());
        objInfo[2]=String.valueOf(zm.getUsedAttempts());
        objInfo[3]=String.valueOf(zm.getDate());
        objInfo[4]=String.valueOf(zm.getExaminationByExaminationId().getExaminationId());
        return objInfo;
    }
}
