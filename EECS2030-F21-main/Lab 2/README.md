## Lab 2 is The Vaccination Tracker Problem
**Lab design by Professor Chen-Wei(Jackie) Wang**

This object-oriented program is solving a simplified vaccination tracker problem, where COVID-19 vaccines are distributed and administered through dedicated vaccination sites, and registered patients are able to obtain proof of received vaccine doses:

#### **The relevant entities involved in this problem:**
- Each ***vaccine*** is characterized by its unique codename (e.g.,**BNT162b2**), type (e.g.,**RNA**), and manufacturer (e.g.,**Pfizer/BioNTech**). For the purpose of this lab, note the codenames of **the four vaccines approved/rec-ognized in Canada: mRNA-1273, BNT162b2, Ad26.COV2.S, and AZD1222**. There are also other vaccines recognized by WHO but not in Canada: [Link](https://covid19.trackvaccines.org/agency/who/).
- Each ***vaccination distribution*** is characterized by a vaccine (recognized in Canada or not) and its number of doses. Distributions of recognized vaccines are added to and administered by dedicated vaccination sites.
- Each **health record** is characterized by the name of a patient and a collection of vaccination data. Each data item denotes a dose which the patient received, and it includes information of the vaccine, the name of vaccination site, and the date of vaccination. A receipt may be generated, summarizing the patient's vaccination data.
- Each ***vaccination site*** is characterized by its supply (accumulated from various vaccine distributions) and a list of vaccination appointments. The maximum number of available vaccine kinds in a site is **4**, corresponding to the number of vaccines recognized in Canada. When a site is first constructed, a limit is specified to constrain the maximum supply (i.e., number of doses available to be administered). Therefore, for a vaccine distribution to be added to the site, it must be that the vaccine is recognized in Canada, and that adding it will not exceed the pre-set limit. Furthermore, one may inquire about the current supply level for each kind of vaccines, or about the total supply across all kinds.
The maximum number of allowed appointments for each site is always **200**. A patient's appointment request is only accepted if the current supply can afford (despite the kinds). The list of patient appointments is administered on a regular (e.g., daily) basis, by consuming the required doses for those registered patients and resetting/clearing the appointment list for new patients.

###### An Example Vaccine Receipt/Proof
![2 1](https://user-images.githubusercontent.com/90284881/148712385-554e062e-ad11-498d-b94a-2468c085797b.png)
###### Vaccines Recognized in Canada [Link](https://www.canada.ca/en/health-canada/services/drugs-health-products/covid19-industry/drugs-vaccines-treatments/vaccines.html)
![2 2](https://user-images.githubusercontent.com/90284881/148712388-6aba84bc-06c1-4c09-8931-d56fb214cff5.png)
