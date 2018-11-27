package cn.bdqn.gaobingfa.entity;

import cn.bdqn.gaobingfa.Util.PageParams;
import cn.bdqn.gaobingfa.Util.TimeUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Table
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class BehaviorRecordSync implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime accessTime;

    private String code;

    private String note;

    private String ownerAction;

    private String warrant;

    private String cardType;

    private String cardStatus;

    private String peopleName;

    private String peoplePhoto;

    private  String equipmentCode;

    private  String equipmentAddress; //门禁机位置

    private  String pic;

    private  String type;

    private  String peopleIdCard;

    private String keyPerson;
    @Transient
    private PageParams pageParams;//分页参数

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public BehaviorRecordSync() {
    }

    @Override
    public String toString() {
        return "BehaviorRecordSync{" +
                "id=" + id +
                ", accessTime=" + accessTime +
                ", code='" + code + '\'' +
                ", note='" + note + '\'' +
                ", ownerAction='" + ownerAction + '\'' +
                ", warrant='" + warrant + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardStatus='" + cardStatus + '\'' +
                ", peopleName='" + peopleName + '\'' +
                ", equipmentCode='" + equipmentCode + '\'' +
                ", equipmentAddress='" + equipmentAddress + '\'' +
                ", type='" + type + '\'' +
                ", peopleIdCard='" + peopleIdCard + '\'' +
                ", keyPerson='" + keyPerson + '\'' +
                '}';
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {

        this.accessTime = TimeUtils.DateforString(accessTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getOwnerAction() {
        return ownerAction;
    }

    public void setOwnerAction(String ownerAction) {
        this.ownerAction = ownerAction == null ? null : ownerAction.trim();
    }

    public String getWarrant() {
        return warrant;
    }

    public void setWarrant(String warrant) {
        this.warrant = warrant == null ? null : warrant.trim();
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPeopleIdCard() {
        return peopleIdCard;
    }

    public void setPeopleIdCard(String peopleIdCard) {
        this.peopleIdCard = peopleIdCard == null ? null : peopleIdCard.trim();
    }

    public String getEquipmentAddress() {
        return equipmentAddress;
    }

    public void setEquipmentAddress(String equipmentAddress) {
        this.equipmentAddress = equipmentAddress;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    public String getPeoplePhoto() {
        return peoplePhoto;
    }

    public void setPeoplePhoto(String peoplePhoto) {
        this.peoplePhoto = peoplePhoto;
    }
}