package com.logistyx.utilities.interfaces.BNP.BNP_BUS_PRCL.Weight_Cases_NL_SE;

public interface BNPJson7 {
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
           "            \"Reference\": \"Freys Hotel\",\n" +
           "            \"AddressLines\": [\n" +
           "                {\n" +
           "                    \"Index\": 1,\n" +
           "                    \"Value\": \"Bryggargatan 12\"\n" +
           "                }\n" +
           "            ],\n" +
           "            \"PostalCode\": \"10131\",\n" +
           "            \"LocalityName\": \"STOCKHOLM\",\n" +
           "            \"CountryCode\": \"SE\",\n" +
           "            \"Remark\": \"Delivery/Sweden\",\n" +
           "            \"Contacts\": [\n" +
           "                {\n" +
           "                    \"Name\": \"Carl Gustav King\",\n" +
           "                    \"EmailAddress\": \"stockholm@email.com\",\n" +
           "                    \"PhoneNumber\": \"+46633333333\"\n" +
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
           "    \"Weight\": 15000,\n" +
           "    \"WeightUnitOfMeasure\": \"GRM\",\n" +
           "    \"Info\": \"S.Info\",\n" +
           "    \"RequestedPickupDateTime\": \"2022-01-21T14:22:17.59Z\",\n" +
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
           "            \"GrossWeight\": 15000,\n" +
           "            \"GrossWeightUnitOfMeasure\": \"GRM\",\n" +
           "            \"Content\": \"001010000000008853\"\n" +
           "        }\n" +
           "    ]\n" +
           "}";
}
