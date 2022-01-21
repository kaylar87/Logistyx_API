package com.logistyx.utilities.interfaces.BNP.BNP_BUS_PRCL.Weight_Cases_NL_NO;

public interface BNPJson6 {
   String requestJsonBodyShipments = "{\n" +
           "    \"ShipperCode\": \"CEVA\",\n" +
           "    \"ProjectCode\": \"THESTAND\",\n" +
           "    \"ShippingFlowCode\": \"OUTBOUND\",\n" +
           "    \"ForwarderDivisionCode\": \"BNP\",\n" +
           "    \"ForwarderServiceCode\": \"BNP-BUS-PRCL\",\n" +
           "    \"ShipperRef\": \"s.ShipperRef\",\n" +
           "    \"Addresses\": [\n" +
           "        {\n" +
           "            \"Reference\": \"CEVA pickups\",\n" +
           "            \"AddressLines\": [\n" +
           "                {\n" +
           "                    \"Index\": 1,\n" +
           "                    \"Value\": \"Earl Bakkenstraat 7\"\n" +
           "                }\n" +
           "            ],\n" +
           "            \"PostalCode\": \"6422 PJ\",\n" +
           "            \"LocalityName\": \"HEERLEN\",\n" +
           "            \"CountryCode\": \"NL\",\n" +
           "            \"Remark\": \"Pickup location / CEVA\",\n" +
           "            \"Contacts\": [\n" +
           "                {\n" +
           "                    \"Name\": \"Randall Flagg\",\n" +
           "                    \"EmailAddress\": \"r.flagg@thestand.com\",\n" +
           "                    \"PhoneNumber\": \"31688877766\"\n" +
           "                }\n" +
           "            ],\n" +
           "            \"ForwarderDivisionAccounts\": null,\n" +
           "            \"AddressTypes\": [\n" +
           "                {\n" +
           "                    \"AddressTypeCode\": \"PICKUP\"\n" +
           "                }\n" +
           "            ]\n" +
           "        },\n" +
           "        {\n" +
           "            \"AddressTypes\": [\n" +
           "                {\n" +
           "                    \"AddressTypeCode\": \"DELIVERY\"\n" +
           "                }\n" +
           "            ],\n" +
           "            \"Reference\": \"DY.REFERENCE\",\n" +
           "            \"AddressLines\": [\n" +
           "                {\n" +
           "                    \"Index\": 1,\n" +
           "                    \"Value\": \"Grand Hotel Oslo\"\n" +
           "                },\n" +
           "                {\n" +
           "                    \"Index\": 2,\n" +
           "                    \"Value\": \"Karl Johans gate 31\"\n" +
           "                }\n" +
           "            ],\n" +
           "            \"PostalCode\": \"0159\",\n" +
           "            \"LocalityName\": \"OSLO\",\n" +
           "            \"CountryCode\": \"NO\",\n" +
           "            \"Remark\": \"DY.Remark\",\n" +
           "            \"Contacts\": [\n" +
           "                {\n" +
           "                    \"Name\": \"DY.Contact Name\",\n" +
           "                    \"EmailAddress\": \"delivery@email.com\",\n" +
           "                    \"PhoneNumber\": \"062222222\"\n" +
           "                }\n" +
           "            ]\n" +
           "        }\n" +
           "    ],\n" +
           "    \"Value\": 10,\n" +
           "    \"InsuranceValue\": 10,\n" +
           "    \"CustomsValue\": 10,\n" +
           "    \"IncotermCode\": \"DAP\",\n" +
           "    \"Volume\": 13.36,\n" +
           "    \"VolumeUnitOfMeasure\": \"CMQ\",\n" +
           "    \"Weight\": 25.000000,\n" +
           "    \"WeightUnitOfMeasure\": \"KGM\",\n" +
           "    \"Info\": \"S.Info\",\n" +
           "    \"RequestedPickupDateTime\": \"2022-01-20T20:39:33.027Z\",\n" +
           "    \"ShippingUnits\": [\n" +
           "        {\n" +
           "            \"ShipperRef\": \"SU.ShipperRef\",\n" +
           "            \"ReceiverRef\": \"SU.ReceiverRef\",\n" +
           "            \"Length\": 33,\n" +
           "            \"Width\": 27,\n" +
           "            \"Height\": 15,\n" +
           "            \"DimensionsUnitOfMeasure\": \"CMT\",\n" +
           "            \"Volume\": 13360,\n" +
           "            \"VolumeUnitOfMeasure\": \"QCM\",\n" +
           "            \"PackageType\": \"BX\",\n" +
           "            \"GrossWeight\": 25.000000,\n" +
           "            \"GrossWeightUnitOfMeasure\": \"KGM\",\n" +
           "            \"Content\": \"001010000000008853\"\n" +
           "        }\n" +
           "    ]\n" +
           "}";
}
