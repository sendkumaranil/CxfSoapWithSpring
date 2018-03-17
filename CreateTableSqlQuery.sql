CREATE TABLE `flightsdetails` (
  `flightid` varchar(25) NOT NULL DEFAULT '',
  `flightname` varchar(50) DEFAULT NULL,
  `sources` varchar(25) DEFAULT NULL,
  `destination` varchar(25) DEFAULT NULL,
  `depttime` varchar(10) DEFAULT NULL,
  `arrivaltime` varchar(10) DEFAULT NULL,
  `nostop` int(11) DEFAULT NULL,
  `stopageairport` varchar(100) DEFAULT NULL,
  `totalfare` decimal(10,2) DEFAULT NULL,
  `totalseats` int(11) DEFAULT NULL,
  PRIMARY KEY (`flightid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `bookingdetails` (
  `bookingid` int(11) NOT NULL AUTO_INCREMENT,
  `bookingdate` varchar(25) DEFAULT NULL,
  `flightid` varchar(25) DEFAULT NULL,
  `traveldate` varchar(25) DEFAULT NULL,
  `boardingairport` varchar(100) DEFAULT NULL,
  `arrivalairport` varchar(100) DEFAULT NULL,
  `passengername` varchar(25) DEFAULT NULL,
  `govtid` varchar(25) DEFAULT NULL,
  `govtidtype` varchar(25) DEFAULT NULL,
  `travelclass` varchar(25) DEFAULT NULL,
  `adults` int(11) DEFAULT NULL,
  `children` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookingid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

