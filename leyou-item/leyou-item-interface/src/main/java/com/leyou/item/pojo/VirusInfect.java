package com.leyou.item.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "virus_infect")
public class VirusInfect {

    @Id
    private Long logid;

    private String virusname;
    private Integer virustype;
    private String virustypedesc;
    private String viruspath;
    private String virusmd5;
    private Date occurtime;
    private Integer cleantime;
    private Integer issync;
    private Integer eventtype;
    private Integer filesize;
    private Integer fileorigin;
    private Integer opresult;
    private Integer osversion;
    private String guid;
    private String hostname;
    private Long ip;
    private Long mask;
    private String mac;
    private String winuser;
    private String depnamelevel1;
    private String depnamelevel2;
    private String depnamelevel3;
    private String depnamelevel4;
    private String depnamelevel5;
    private Long serverip;
    private Date logtime;
    private String hostIp;
    private String cityCode;
    private Integer networkType;

}
