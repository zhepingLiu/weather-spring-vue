DROP TABLE IF EXISTS `AREA_SAFE_INDEX`;
CREATE TABLE `AREA_SAFE_INDEX` (
  `UUID` varchar(36) NOT NULL,
  `NAME` varchar(128) NOT NULL,
  `BUILD_ID` varchar(12) NOT NULL,
  `RAIL_IDS` text,
  `AREA_IDS` text,
  `FORMULA` text,
  `THRESHOLD_VALUE` double DEFAULT '0',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`UUID`),
  KEY `IDX_AREA_SAFE_INDEX_BUILD_ID` (`BUILD_ID`),
  KEY `IDX_AREA_SAFE_INDEX_NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `AREA_PERSON_COUNT`;
CREATE TABLE `AREA_PERSON_COUNT` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `AREA_ID` varchar(36) DEFAULT NULL,
  `BINDER_ID` varchar(24) DEFAULT NULL,
  `TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `AREA_PERSON_COUNT_IDX_AREA_ID` (`AREA_ID`),
  KEY `AREA_PERSON_COUNT_IDX_TIME` (`TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ALARM_EVENT_AREA_REL`;
CREATE TABLE `ALARM_EVENT_AREA_REL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `REL_ID` varchar(32) DEFAULT NULL,
  `REL_TYPE` varchar(64) DEFAULT 'area',
  `ALARM_EVENT_ID` varchar(32) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;