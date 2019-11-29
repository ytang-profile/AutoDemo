//package com.healthtool.automation.main;
//
//import java.net.MalformedURLException;
//import java.util.*;
//import org.apache.commons.lang3.StringUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.*;
//import com.healthtool.automation.model.*;
//import com.healthtool.automation.page.*;
//import com.healthtool.automation.utilities.Browser;
//import com.healthtool.automation.utilities.ExcelReaderWriter;
//
//public class HeT_Automation extends Browser {
//
//	// Page Objects
//	private InnerLinkPage innerLinkPage;
//	private EntityInfoPage entityInfoPage;
//	private WebDriver driver;
//	private DesiredCapabilities capability;
//	private final String fileV1 = "SchoolDistrictsV1.xlsx";
//	private final String fileV2 = "SchoolDistrictsV2.xlsx";
//
//	@BeforeClass
//	public void setUp() throws MalformedURLException {
//
//		driver = DriverFactory.getDriver("chrome");
//		innerLinkPage = new InnerLinkPage(driver);
//		entityInfoPage = new EntityInfoPage(driver);
//	}
//	
//	
//
//
////	 @Test(priority = 0)
//	public void getSchoolDistrictsInfo() throws Exception {
//		Set<EntityInfo> schoolDistrictsV1 = this.getSchoolDistrictsInfoV1(0);
//		ExcelReaderWriter.write(schoolDistrictsV1, "./Report/"+"SchoolDistrictsV1.xlsx", "SchoolDistricts");
//
////		Set<EntityInfo> schoolDistrictsV2 = this.getSchoolDistrictInfoV2(5);
////		ExcelReaderWriter.write(schoolDistrictsV2, "./Report/"+"SchoolDistrictsV2.xlsx", "SchoolDistricts");
//
//	}
//	
////	@Test(priority = 0)
//	public void getAllinformationsForDistrict() throws Exception {
//		
//		
//		Set<EntityInfo> schoolDistricts = new HashSet<>();
//		List<SchoolInfo> schoolInfoList = new ArrayList<>();
//		SchoolDistrictStaff schoolDistrictStaff = new SchoolDistrictStaff();
//		List<Staff> allTeachers = new ArrayList<>();
//	
//
//		loginToV1("innerlinkURl","nepaUserName","nepaPassword");
//
//		WebElement innerLinkExpandButton = innerLinkPage.getInnerLinkExpandButtons();
//		innerLinkExpandButton.click();
//
//		// Getting County expand buttons
//		List<WebElement> countyExpandButtons = innerLinkPage.getCountyExpandButtons();
//		System.out.println("The County size ---> " + countyExpandButtons.size());
//
//		for (WebElement countyExpandButton : countyExpandButtons) {
//
//			// Clicking on each County expand button
//			countyExpandButton.click();
//		}
//		
//		//List<WebElement> schoolDistrictsExpandButtons= driver.findElements(By.xpath(""));
//		//*[@id = 'site_2']/div/a/img/./../../following-sibling::div/./div[@style = 'white-space: nowrap;']/a/img
//		//*[@id = 'site_2']/div/a/img/./../../following-sibling::div/./div[@style = 'white-space: nowrap;']/a/img/../following-sibling::a
//		//			List<WebElement> schoolDistrictsExpandButtons = innerLinkPage
////					.getSchoolDistrictExpandButtons(countyExpandButton);
////
////			System.out.println("The School Distric size in a County ---> " + schoolDistrictsExpandButtons.size());
//			
//		//a[contains(text(),'Gettysburg Area School District')]
//		
//		WebElement districtExpBtn = driver.findElement(By.xpath("(//a[contains(text(),'Gettysburg Area School District')]/../a)[1]"));
//		districtExpBtn.click();
//		sleep(2);
//		WebElement district = driver.findElement(By.xpath("(//a[contains(text(),'Gettysburg Area School District')]/../a)[2]"));
//		district.click();
//		sleep(5);
//		//int counter = 0;
////			for (WebElement schoolDistrictExpandButton : schoolDistrictsExpandButtons) {
////
//				EntityInfo schoolDistrictInfo = new EntityInfo();
////
////				WebElement schoolDistrictLink = innerLinkPage.getSchoolDistrictLink(schoolDistrictExpandButton);
////				schoolDistrictLink.click();
////				Thread.sleep(300);
//				EntityInfo previousSchoolDistrictInfo = null;
//				schoolDistrictInfo = getEntityInfoFromUI(entityInfoPage, district,
//						previousSchoolDistrictInfo);
//				System.out.println(schoolDistrictInfo);
//				schoolDistricts.add(schoolDistrictInfo);
//	
//				List<WebElement> schoolsLinks =  driver.findElements(By.xpath("//div[@id='site_1916']//div[@style = 'white-space: nowrap;']")); //innerLinkPage.getSchoolsLinks(schoolDistrictLink);
//				System.out.println("School size in a District---> " + schoolsLinks.size());
//
//				EntityInfo previousSchoolInfo = null;
//
//				for (WebElement schoolLink : schoolsLinks) {
//
//					schoolLink.click();
//					Thread.sleep(300);
//
//					// Getting the all school info
//					EntityInfo entityInfo = getEntityInfoFromUI(entityInfoPage, schoolLink, previousSchoolInfo);
//
//					SchoolInfo schoolInfo = new SchoolInfo();
//					schoolInfo.setSchoolDistrictName(district.getText());
//					schoolInfo.setSiteId(entityInfo.getSiteId());
//					schoolInfo.setSchoolName(entityInfo.getName());
//					schoolInfo.setTelephone(entityInfo.getTelephone());
//					schoolInfo.setStreetLine1(entityInfo.getStreetLine1());
//					schoolInfo.setStreetLine2(entityInfo.getStreetLine2());
//					schoolInfo.setStreetLine3(entityInfo.getStreetLine3());
//					schoolInfo.setCity(entityInfo.getCity());
//					schoolInfo.setProvinceState(entityInfo.getProvinceState());
//					schoolInfo.setPostalCode(entityInfo.getPostalCode());
//
//					schoolInfoList.add(schoolInfo);
//					System.out.println("This is suppose to be School Info -----> " + entityInfo);
//					previousSchoolInfo = entityInfo;
//
//					// driver.switchTo().defaultContent();
//					// page.schoolTab.click();
//					driver.switchTo().defaultContent();
//					driver.switchTo().frame(iFrameNavigator);
//
//				}
//				
//				String schoolDistrictName = district.getText();
//	
//				
//				
////				List<WebElement> schoolsLinks = innerLinkPage.getSchoolsLinks(schoolDistrictLink);
////				System.out.println("School size in a District---> " + schoolsLinks.size());
//
//				//EntityInfo previousSchoolInfo = null;
//
//				for (WebElement schoolLink : schoolsLinks) {
//
//					//School school = new School();
//					
//					schoolLink.click();
//					String schoolName = schoolLink.getText();
//					Thread.sleep(100);
//
//					driver.switchTo().defaultContent();
//
//					// Click on Staff tab
//					click(page.stuff, 10);	
//
//					driver.switchTo().frame(iFrameEditorWin);
//
//					// Select status
//					Select statusDropDown = new Select(driver.findElement(By.name("state")));
//					statusDropDown.selectByVisibleText("Active");
//					page.searchBtn.click();
//					Thread.sleep(200);
//
//					StaffInfoPage staffInfoPage = new StaffInfoPage(driver);
//
//					// Getting list of Teachers
//					List<Staff> teachers = new ArrayList<>();
//					page.teachersTab.click();
//					sleep(1);
//
//					List<WebElement> listOfTeachers = driver.findElements(By.xpath("//*[@id=\"MemberList\"]/*/div/span"));
//					System.out.println("Size of Teachers---->> " + listOfTeachers.size());
//					
//					
//					Staff previousEntity=null;
//					// for (WebElement eachStudent : page.listOfStudents) {
//					for (WebElement teacher : listOfTeachers) {
//						Thread.sleep(200);
//
//							click(teacher, 10);
//							Thread.sleep(500);					
//						if (previousEntity != null) {
//							int timeLimit = 6000;
//							int timer = 0;
//							
//							while (true) {
//								
//								if(!previousEntity.getLegalFirstName().equals(staffInfoPage.getLegalFirstName().getAttribute("value"))) {
//									
//									break;
//								}				
//								Thread.sleep(200);				
//								timer = timer + 200;
//								if (timer > timeLimit) {
//									break;
//								} 
//							}
//						}
//									
//						
//						Staff teacherInfo = staffInfoPage.getStaffInfo();
//						previousEntity = teacherInfo;
//						
//						
//						teacherInfo.setSchoolDistrictInfo(schoolDistrictName);
//						teacherInfo.setSchoolName(schoolName);
//						teachers.add(teacherInfo);
//						System.out.println("Teachers demographic info --->>" + teacherInfo);
//					}
//					allTeachers.addAll(teachers);
//				
//					driver.switchTo().defaultContent();
//					driver.switchTo().frame(iFrameNavigator);
////
//				}
//
//				schoolDistrictStaff.setTeachers(allTeachers);
//				
//	}
//
////	 @Test(priority = 0)
//	public void getDistrictSchoolsInfo() throws Exception {
////		List<SchoolInfo> schoolsV1 = this.getHighLevelSchoolInfoV1(0);
////		ExcelReaderWriter.write(schoolsV1, "./Report/"+fileV1, "Schools");
//
//		List<SchoolInfo> schoolsV2 = this.getHighLevelSchoolInfoV2(0);
//		ExcelReaderWriter.write(schoolsV2, "./Report/"+ fileV2, "Schools");
//	}
//
////	@Test(priority = 0)
//	public void getDistrictsStaffInfo() throws Exception {
//		 
//		 SchoolDistrictStaff staffInfoV1 = this.getSchoolDistrictStaffV1(0);
//		
////		 ExcelReaderWriter.write(staffInfoV1.getAdmins(), "./Report/" +fileV1, "Admins");
////		 ExcelReaderWriter.write(staffInfoV1.getPrincipal(),"./Report/" + fileV1, "Principals");
//		 ExcelReaderWriter.write(staffInfoV1.getTeachers(), "./Report/" +fileV1, "Teachers");
//
////		SchoolDistrictStaff staffInfoV2 = this.getSchoolDistrictStaffV2(2);
////		ExcelReaderWriter.write(staffInfoV2.getAdmins(), "./Report/" + fileV2,
////				"Admins");
////		ExcelReaderWriter.write(staffInfoV2.getPrincipal(), "./Report/" + fileV2,
////				"Principals");
////		ExcelReaderWriter.write(staffInfoV2.getTeachers(), "./Report/" + fileV2,
////				"Teachers");
//	}
//
//	
//	
//	
////	@Test (/*dataProvider= "getDistrictData"*/)
//	public void getSchoolStudentsInfo1(/*String schoolDistrictName*/) throws Exception {
//		
//		SchoolDistrictsStudent studentsV1 = this.getSchoolStudentsV1(0);
//		
//		 ExcelReaderWriter.write(studentsV1.getStudents(), "./Report/"+studentsV1.getSchoolDistrictName()+ ".xlsx", "Students");
//
////		SchoolDistrictsStudent studentsV2 = this.getSchoolStudentsV2(1);
////		ExcelReaderWriter.write(studentsV2.getStudents(), "./Report/" + studentsV2.getSchoolDistrictName() + ".xlsx",
////				"Students");
//
//	}
//	
//
//
//	
//
////	@DataProvider(parallel= true)
//	public Object[][] getTestData(){
//		return new Object[][] {{"Upper Adams SD - Inactive"},{"Littlestown Area School District"}};
//	}
//	
//	// @Test (priority=0)
//	public void VerifySchoolDistrictInfo() {
//
//		List<EntityInfo> schoolDistrictsV1 = ExcelReaderWriter.read("./Report/"+fileV1, "SchoolDistricts", EntityInfo.class);
//		List<EntityInfo> schoolDistrictsV2 = ExcelReaderWriter.read("./Report/"+fileV2, "SchoolDistricts", EntityInfo.class);
//
//		List<EntityInfo> schoolDistrictsV1Clone = new ArrayList<>(schoolDistrictsV1.size());
//		List<EntityInfo> schoolDistrictsV2Clone = new ArrayList<>(schoolDistrictsV2.size());
//
//		for (EntityInfo ei : schoolDistrictsV1) {
//			schoolDistrictsV1Clone.add((EntityInfo) ei.clone());
//		}
//
//		for (EntityInfo ei : schoolDistrictsV2) {
//			schoolDistrictsV2Clone.add((EntityInfo) ei.clone());
//		}
//
//		// Collections.copy(schoolDistrictsV1Clone, schoolDistrictsV1);
//		// Collections.copy(schoolDistrictsV2Clone, schoolDistrictsV2);
//
//		// V1 schools missing in V2
//		schoolDistrictsV1.removeAll(schoolDistrictsV2);
//
//		// V2 schools missing in V1
//		schoolDistrictsV2Clone.removeAll(schoolDistrictsV1Clone);
//
//		// V1 and V2 common schools
//		schoolDistrictsV1Clone.retainAll(schoolDistrictsV2);
//
//		ExcelReaderWriter.write(schoolDistrictsV1Clone, "./Report/"+"SchoolDistrictsComparisionResults.xlsx",
//				"V1AndV2CommonSchools");
//		ExcelReaderWriter.write(schoolDistrictsV1,"./Report/"+ "SchoolDistrictsComparisionResults.xlsx",
//				"V1SchoolDistrictsMissingInV2");
//		ExcelReaderWriter.write(schoolDistrictsV2Clone, "./Report/"+"SchoolDistrictsComparisionResults.xlsx",
//				"V2SchoolDistrictsMissingInV1");
//
//		// System.out.println(Arrays.toString(schoolDistricts.toArray()));
//
//	}
//
//	 @Test(priority = 0)
//	public void VerifySchoolInfo1() {
//
//		List<SchoolInfo> schoolsInV1 = ExcelReaderWriter.read("./Report/"+fileV1, "Schools", SchoolInfo.class);
//		List<SchoolInfo> schoolsInV2 = ExcelReaderWriter.read("./Report/"+fileV2, "Schools", SchoolInfo.class);
//
//		List<SchoolInfo> schoolsV1Clone = new ArrayList<>(schoolsInV1.size());
//		List<SchoolInfo> schoolsV2Clone = new ArrayList<>(schoolsInV2.size());
//
//		for (SchoolInfo ei : schoolsInV1) {
//			schoolsV1Clone.add((SchoolInfo) ei.clone());
//		}
//
//		for (SchoolInfo ei : schoolsInV2) {
//			schoolsV2Clone.add((SchoolInfo) ei.clone());
//		}
//
//		// Collections.copy(schoolDistrictsV1Clone, schoolDistrictsV1);
//		// Collections.copy(schoolDistrictsV2Clone, schoolDistrictsV2);
//
//		// V1 schools missing in V2
//		schoolsInV1.removeAll(schoolsInV2);
//
//		// V2 schools missing in V1
//		schoolsV2Clone.removeAll(schoolsV1Clone);
//
//		// V1 and V2 common schools
//		schoolsV1Clone.retainAll(schoolsInV2);
//
//		ExcelReaderWriter.write(schoolsV1Clone, "./Report/"+"SchoolsComparisionResults.xlsx", "V1AndV2CommonSchools");
//		ExcelReaderWriter.write(schoolsInV1, "./Report/"+"SchoolsComparisionResults.xlsx", "V1SchoolsMissingInV2");
//		ExcelReaderWriter.write(schoolsV2Clone,"./Report/"+ "SchoolsComparisionResults.xlsx", "V2SchoolsMissingInV1");
//
//		// System.out.println(Arrays.toString(schoolDistricts.toArray()));
//
//	}
//
//	// @Test
//	public void VerifySchoolDistrictStuffInfo1() {
//
//		List<EntityInfo> districtStuffsV1 = ExcelReaderWriter.read(fileV1, "SchoolDistricts", EntityInfo.class);
//		List<EntityInfo> districtStuffsV2 = ExcelReaderWriter.read(fileV2, "SchoolDistricts", EntityInfo.class);
//
//		List<EntityInfo> districtStuffsV1Clone = new ArrayList<>(districtStuffsV1.size());
//		List<EntityInfo> districtStuffsV2Clone = new ArrayList<>(districtStuffsV2.size());
//
//		for (EntityInfo ei : districtStuffsV1) {
//			districtStuffsV1Clone.add((EntityInfo) ei.clone());
//		}
//
//		for (EntityInfo ei : districtStuffsV2) {
//			districtStuffsV2Clone.add((EntityInfo) ei.clone());
//		}
//
//		// Collections.copy(schoolDistrictsV1Clone, schoolDistrictsV1);
//		// Collections.copy(schoolDistrictsV2Clone, schoolDistrictsV2);
//
//		// V1 schools missing in V2
//		districtStuffsV1.removeAll(districtStuffsV2);
//
//		// V2 schools missing in V1
//		districtStuffsV2Clone.removeAll(districtStuffsV1Clone);
//
//		// V1 and V2 common schools
//		districtStuffsV1Clone.retainAll(districtStuffsV2);
//
//		ExcelReaderWriter.write(districtStuffsV1Clone, "DistrictStuffsComparisionResults.xlsx", "V1AndV2CommonStuffs");
//		ExcelReaderWriter.write(districtStuffsV1, "DistrictsComparisionResults.xlsx", "V1DistrictStuffsMissingInV2");
//		ExcelReaderWriter.write(districtStuffsV2Clone, "DistrictsComparisionResults.xlsx",
//				"V2DistrictStuffsMissingInV1");
//
//		// System.out.println(Arrays.toString(schoolDistricts.toArray()));
//
//	}
//
//	
//
////	@DataProvider(parallel= true)
//	public String[] getDistrictData() throws Exception {
//		String arr[] =null;
//		String districtName = null;
//
//		//loginToV1();
//
//		// logic for school district -- starts here..
//
//		List<WebElement> possibleSchools = driver
//				.findElements(By.xpath("//div/div/a[starts-with(@onclick,'LoadSite')]"));
//
//		Map<String, Set<String>> districtSchoolMap = new HashMap<>();
//		List<String> ignoreList = new ArrayList();
//
//		schoolLevelLoop: for (WebElement eachPossibleSchool : possibleSchools) {
//			String schoolId = eachPossibleSchool.getAttribute("id");
//			// if a school is already mapped, skip it.
//			if (ignoreList.contains(schoolId)) {
//				continue schoolLevelLoop;
//			}
//
//			try {
//				// based on style on inner /div/div/a differentiate school and district
//				String style = eachPossibleSchool.getAttribute("style");
//				if (!StringUtils.isEmpty(style)) {
//					continue;
//				}
//
//				// get parent node of school -- this is div
//				WebElement currentSchoolDiv = eachPossibleSchool.findElement(By.xpath(".."));
//
//				// get grandparent node of school this div has all the schools under that
//				// district
//				WebElement parentDivForAllSchools = currentSchoolDiv.findElement(By.xpath(".."));
//
//				// obtain all schools under a group div for the district
//				List<WebElement> listOfSchoolsUnderADiv = parentDivForAllSchools
//						.findElements(By.xpath("./child::*/a[1]"));
//				Set<String> listOfSchools = new HashSet();
//				for (WebElement webElement : listOfSchoolsUnderADiv) {
//					String eachSchool = webElement.getAttribute("text");
//					if (!StringUtils.isEmpty(eachSchool)) {
//						listOfSchools.add(eachSchool);
//
//					}
//					ignoreList.add(webElement.getAttribute("id"));
//				}
//				// get immediate preceeding href for div school group. This will be district,
//				// sometimes when a school doesn't have district, this will be county
//				WebElement preceedingBoldDiv = parentDivForAllSchools
//						.findElement(By.xpath("preceding-sibling::div[1]/a[2]"));
//
//				districtName = preceedingBoldDiv.getAttribute("text");
//				districtSchoolMap.put(districtName, null);
//				System.out.println(districtName);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			Set<String> districts = districtSchoolMap.keySet();
//			 arr = new String[districts.size()];
//			arr = districts.toArray(arr);
//		}
//		
//		return arr;
//		//return new Object[][] {{"Upper Adams SD - Inactive"},{"Littlestown Area School District"}};
//	}
//	
//	
////	@DataProvider
//	public String[] testDataProvider() {
//		List testList = new ArrayList<>();
//		testList.add("test2");
//		testList.add("test1");
//		String[] hi= new String[3];
//		hi[0]="test1";
//		hi[1]="test2";
//		
//		return hi;
//	}
//
//	public Set<EntityInfo> getSchoolDistrictsInfoV1(int numberOfSchoolDistricts) throws Exception {
//		Set<EntityInfo> schoolDistricts = new HashSet<>();
//
//		loginToV1("innerNEPALink","nepaUserName","nepaPassword");
//
//		WebElement innerLinkExpandButton = innerLinkPage.getInnerLinkExpandButtons();
//		innerLinkExpandButton.click();
//
//		// Getting County expand buttons
//		List<WebElement> countyExpandButtons = innerLinkPage.getCountyExpandButtons();
//		System.out.println("The County size ---> " + countyExpandButtons.size());
//
//		for (WebElement countyExpandButton : countyExpandButtons) {
//
//			// Clicking on each County expand button
//			countyExpandButton.click();
//
//			List<WebElement> schoolDistrictsExpandButtons = innerLinkPage
//					.getSchoolDistrictExpandButtons(countyExpandButton);
//
//			System.out.println("The School Distric size in a County ---> " + schoolDistrictsExpandButtons.size());
//			int counter = 0;
//			for (WebElement schoolDistrictExpandButton : schoolDistrictsExpandButtons) {
//
//				EntityInfo schoolDistrictInfo = new EntityInfo();
//
//				WebElement schoolDistrictLink = innerLinkPage.getSchoolDistrictLink(schoolDistrictExpandButton);
//				schoolDistrictLink.click();
//				Thread.sleep(300);
//				EntityInfo previousSchoolDistrictInfo = null;
//				schoolDistrictInfo = getEntityInfoFromUI(entityInfoPage, schoolDistrictLink,
//						previousSchoolDistrictInfo);
//				System.out.println(schoolDistrictInfo);
//				schoolDistricts.add(schoolDistrictInfo);
//
//				if (++counter == numberOfSchoolDistricts) {
//					return schoolDistricts;
//				}
//			}
//			countyExpandButton.click();
//		}
//		return schoolDistricts;
//	}
//
//	public Set<EntityInfo> getSchoolDistrictInfoV2(int numberOfSchoolDistricts) throws Exception {
//
//		loginToV2();
//
//		sleep(2);
//
//		Set<EntityInfo> schoolDistricts = new HashSet<>();
//
//		Select districtDropDownList = new Select(driver
//				.findElement(By.xpath("//select[@class= 'border customStyle w-100 select-in-nav border-secondary']")));
//
//		page.administration.click();
//		sleep(1);
//
//		page.boardManager.click();
//		sleep(1);
//		int counter = 0;
//		for (int i = 0; i < districtDropDownList.getOptions().size(); i++) {
//
//			districtDropDownList.selectByIndex(i);
//
//			EntityInfo schoolDistrictInfo = new EntityInfoPageV2(driver).getEntityInfo();
//
//			schoolDistricts.add(schoolDistrictInfo);
//			sleep(1);
//
//			System.out.println("District Info ---->>> " + schoolDistrictInfo);
//			if (++counter == numberOfSchoolDistricts) {
//				return schoolDistricts;
//			}
//		}
//		return schoolDistricts;
//	}
//
//	public List<SchoolInfo> getHighLevelSchoolInfoV1(int numberOfSchoolDistricts) throws Exception {
//
//		loginToV1("innerlinkURl","nepaUserName","nepaPassword");
//
//		List<SchoolInfo> schoolInfoList = new ArrayList<>();
//
//		// Clicking on inner link expand button
//		WebElement innerLinkExpandButton = innerLinkPage.getInnerLinkExpandButtons();
//		click(innerLinkExpandButton, 5);
//
//		// Getting County expand buttons
//		List<WebElement> countyExpandButtons = innerLinkPage.getCountyExpandButtons();
//		System.out.println("The County size ---> " + countyExpandButtons.size());
//
//		int counter = 0;
//		for (WebElement countyExpandButton : countyExpandButtons) {
//
//			// Clicking on each County expand button
//			countyExpandButton.click();
//
//			List<WebElement> schoolDistrictsExpandButtons = innerLinkPage
//					.getSchoolDistrictExpandButtons(countyExpandButton);
//
//			System.out.println("The School Distric size in a County ---> " + schoolDistrictsExpandButtons.size());
//
//			for (WebElement schoolDistrictExpandButton : schoolDistrictsExpandButtons) {
//
//				// EntityInfo schoolDistrictInfo = new EntityInfo();
//
//				// Clicking on each school district
//				schoolDistrictExpandButton.click();
//				sleep(1);
//
//				WebElement schoolDistrictLink = innerLinkPage.getSchoolDistrictLink(schoolDistrictExpandButton);
//
//				List<WebElement> schoolsLinks = innerLinkPage.getSchoolsLinks(schoolDistrictLink);
//				System.out.println("School size in a District---> " + schoolsLinks.size());
//
//				EntityInfo previousSchoolInfo = null;
//
//				for (WebElement schoolLink : schoolsLinks) {
//
//					schoolLink.click();
//					Thread.sleep(300);
//
//					// Getting the all school info
//					EntityInfo entityInfo = getEntityInfoFromUI(entityInfoPage, schoolLink, previousSchoolInfo);
//
//					SchoolInfo schoolInfo = new SchoolInfo();
//					schoolInfo.setSchoolDistrictName(schoolDistrictLink.getText());
//					schoolInfo.setSiteId(entityInfo.getSiteId());
//					schoolInfo.setSchoolName(entityInfo.getName());
//					schoolInfo.setTelephone(entityInfo.getTelephone());
//					schoolInfo.setStreetLine1(entityInfo.getStreetLine1());
//					schoolInfo.setStreetLine2(entityInfo.getStreetLine2());
//					schoolInfo.setStreetLine3(entityInfo.getStreetLine3());
//					schoolInfo.setCity(entityInfo.getCity());
//					schoolInfo.setProvinceState(entityInfo.getProvinceState());
//					schoolInfo.setPostalCode(entityInfo.getPostalCode());
//
//					schoolInfoList.add(schoolInfo);
//					System.out.println("This is suppose to be School Info -----> " + entityInfo);
//					previousSchoolInfo = entityInfo;
//
//					// driver.switchTo().defaultContent();
//					// page.schoolTab.click();
//					driver.switchTo().defaultContent();
//					driver.switchTo().frame(iFrameNavigator);
//
//				}
//
//				schoolDistrictExpandButton.click();
//				if (++counter == numberOfSchoolDistricts) {
//					return schoolInfoList;
//				}
//			}
//
//			countyExpandButton.click();
//
//		}
//
//		return schoolInfoList;
//	}
//
//	public List<SchoolInfo> getHighLevelSchoolInfoV2(int numberOfSchoolDistricts) throws Exception {
//
//		loginToV2();
//
//		Thread.sleep(500);
//
//		// HashMap<EntityInfo, List<SchoolInfo>> allSchoolDistrictInfo = new
//		// HashMap<>();
//		List<SchoolInfo> schoolInfoList = new ArrayList<>();
//
//		Select districtDropDownList = new Select(driver
//				.findElement(By.xpath("//select[@class= 'border customStyle w-100 select-in-nav border-secondary']")));
//
//		page.administration.click();
//		Thread.sleep(100);
//
//		page.boardManager.click();
//		Thread.sleep(100);
//
//		int counter = 0;
//
//		for (int i = 0; i < districtDropDownList.getOptions().size(); i++) {
//			districtDropDownList.selectByIndex(i);
//			Thread.sleep(500);
//
//			EntityInfo schoolDistrictInfo = new EntityInfoPageV2(driver).getEntityInfo();
//
//			page.administration.click();
//			Thread.sleep(100);
//
//			page.schoolManager.click();
//			Thread.sleep(100);
//
//			Select schoolDropDowmList = new Select(driver.findElement(
//					By.xpath("//select[@class= 'border customStyle w-100 select-in-nav border-secondary mt-1']")));
//
//			//List<SchoolInfo> schoolsInfo = new ArrayList<>();
//
//			EntityInfo previousSchoolInfo = null;
//
//			for (int j = 0; j < schoolDropDowmList.getOptions().size(); j++) {
//				schoolDropDowmList.selectByIndex(j);
//
//				EntityInfo entityInfo = new EntityInfoPageV2(driver).getEntityInfo();
//				System.out.println("School Info   --->>>" + entityInfo);
//				sleep(1);
//				SchoolInfo schoolInfo = new SchoolInfo();
//				schoolInfo.setSchoolDistrictName(schoolDistrictInfo.getName());
//				schoolInfo.setSchoolName(entityInfo.getName());
//				schoolInfo.setTelephone(entityInfo.getTelephone());
//				schoolInfo.setStreetLine1(entityInfo.getStreetLine1());
//				schoolInfo.setStreetLine2(entityInfo.getStreetLine2());
//				schoolInfo.setStreetLine3(entityInfo.getStreetLine3());
//				schoolInfo.setCity(entityInfo.getCity());
//				schoolInfo.setProvinceState(entityInfo.getProvinceState());
//				schoolInfo.setPostalCode(entityInfo.getPostalCode());
//
//				// TODO set all fields
//
//				schoolInfoList.add(schoolInfo);
//
//				previousSchoolInfo = entityInfo;
//			}
//
//			page.administration.click();
//			Thread.sleep(100);
//
//			page.boardManager.click();
//			Thread.sleep(100);
//			if (++counter == numberOfSchoolDistricts) {
//				return schoolInfoList;
//			}
//		}
//		return schoolInfoList;
//	}
//
//	public SchoolDistrictStaff getSchoolDistrictStaffV1(int numberOfSchoolDistricts) throws Exception {
//
//		loginToV1("innnerIBXLink","nepaUserName","nepaPassword");
//		
//		SchoolDistrictStaff schoolDistrictStaff = new SchoolDistrictStaff();
//		// schoolDistrictStaff.setSchoolDistrictName(schoolDistrictName);
//		int counter = 1;
//		// Clicking on inner link expand button
//		WebElement innerLinkExpandButton = innerLinkPage.getInnerLinkExpandButtons();
//		click(innerLinkExpandButton, 5);
//
//		// Getting County expand buttons
//		List<WebElement> countyExpandButtons = innerLinkPage.getCountyExpandButtons();
//
//		//for (WebElement countyExpandButton : countyExpandButtons) {
//			for (int t =2; t < 3; t++) {
//			
//			countyExpandButtons.get(t).click();
//			// Clicking on each County expand button
//			//countyExpandButton.click();
//
////			List<WebElement> schoolDistrictsExpandButtons = innerLinkPage
////					.getSchoolDistrictExpandButtons(countyExpandButton);
//			List<WebElement> schoolDistrictsExpandButtons = innerLinkPage
//					.getSchoolDistrictExpandButtons(countyExpandButtons.get(t));
//
//			List<Staff> allTeachers = new ArrayList<>();
//			List<Staff> allPrincipals = new ArrayList<>();
//			List<Staff> allAdmins = new ArrayList<>();
//
//			for (WebElement schoolDistrictExpandButton : schoolDistrictsExpandButtons) {
//			//for (int i = 0; i < 1; i++) {
//				
//				
//				schoolDistrictExpandButton.click();
//				//schoolDistrictsExpandButtons.get(i).click();
//
//				WebElement schoolDistrictLink = innerLinkPage.getSchoolDistrictLink(schoolDistrictExpandButton);
//				
////				WebElement schoolDistrictLink = innerLinkPage
////						.getSchoolDistrictLink(schoolDistrictsExpandButtons.get(i));
//				
//				String schoolDistrictInfo = schoolDistrictLink.getText();
//	
//				
//				
//				List<WebElement> schoolsLinks = innerLinkPage.getSchoolsLinks(schoolDistrictLink);
//				System.out.println("School size in a District---> " + schoolsLinks.size());
//
//				EntityInfo previousSchoolInfo = null;
//
//				for (WebElement schoolLink : schoolsLinks) {
//
//					School school = new School();
//					
//					schoolLink.click();
//					String schoolName = schoolLink.getText();
//					Thread.sleep(100);
//
//					driver.switchTo().defaultContent();
//
//					// Click on Staff tab
//					click(page.stuff, 10);	
//
//					driver.switchTo().frame(iFrameEditorWin);
//
//					// Select status
//					Select statusDropDown = new Select(driver.findElement(By.name("state")));
//					statusDropDown.selectByVisibleText("Active");
//					page.searchBtn.click();
//					Thread.sleep(200);
//
//					StaffInfoPage staffInfoPage = new StaffInfoPage(driver);
//
//					// Getting list of Teachers
//					List<Staff> teachers = new ArrayList<>();
//					page.teachersTab.click();
//					sleep(1);
//
//					List<WebElement> listOfTeachers = driver.findElements(By.xpath("//*[@id=\"MemberList\"]/*/div/span"));
//					System.out.println("Size of Teachers---->> " + listOfTeachers.size());
//					
//					
//					Staff previousEntity=null;
//					// for (WebElement eachStudent : page.listOfStudents) {
//					for (WebElement teacher : listOfTeachers) {
//						Thread.sleep(200);
//
//							click(teacher, 10);
//							Thread.sleep(500);					
//						if (previousEntity != null) {
//							int timeLimit = 6000;
//							int timer = 0;
//							
//							while (true) {
//								
//								if(!previousEntity.getLegalFirstName().equals(staffInfoPage.getLegalFirstName().getAttribute("value"))) {
//									
//									break;
//								}				
//								Thread.sleep(200);				
//								timer = timer + 200;
//								if (timer > timeLimit) {
//									break;
//								} 
//							}
//						}
//									
//						
//						Staff teacherInfo = staffInfoPage.getStaffInfo();
//						previousEntity = teacherInfo;
//						
//						
//						teacherInfo.setSchoolDistrictInfo(schoolDistrictInfo);
//						teacherInfo.setSchoolName(schoolName);
//						teachers.add(teacherInfo);
//						System.out.println("Teachers demographic info --->>" + teacherInfo);
//					}
//					allTeachers.addAll(teachers);
//
//					// Getting list of Principals
////					List<Staff> principals = new ArrayList<>();
////					page.principalesTab.click();
////					sleep(1);
////
////					List<WebElement> listOfPrincipals = driver.findElements(By.xpath("//*[@id=\"MemberList\"]/*/div/span"));
////					System.out.println("Principles size --->>>> " + listOfPrincipals.size());	
////					
////					Staff previousEntity1=null;
////					for (WebElement principal : listOfPrincipals) {
////						Thread.sleep(100);
////						
////						click(principal, 10);
////						Thread.sleep(300);
////						if (previousEntity1 != null) {
////							int timeLimit = 6000;
////							int timer = 0;
////							
////							while (true) {
////								
////								if(!previousEntity1.getLegalFirstName().equals(staffInfoPage.getLegalFirstName().getAttribute("value"))) {
////									
////									break;
////								}				
////								Thread.sleep(200);				
////								timer = timer + 200;
////								if (timer > timeLimit) {
////									break;
////								} 
////							}
////						}
////													
////					
////						Staff principalInfo = staffInfoPage.getStaffInfo();
////						previousEntity1 = principalInfo;
////						principalInfo.setSchoolDistrictInfo(schoolDistrictInfo);
////						principalInfo.setSchoolName(schoolName);
////						principals.add(principalInfo);
////						System.out.println("Stuff's principles Demographic Info --->>" + principalInfo);
////
////					}
////					allPrincipals.addAll(principals);
////
////					// Getting list of Admins
////					List<Staff> admins = new ArrayList<>();
////					page.adminsTab.click();
////					sleep(1);
////
////					List<WebElement> listOfStuffAdmins = driver.findElements(By.xpath("//*[@id=\"MemberList\"]/*/div/span"));
////					System.out.println("Admins size--->>>" + listOfStuffAdmins.size());
////
////					
////					
////					Staff previousEntity2=null;
////					for (WebElement admin : listOfStuffAdmins) {
////						Thread.sleep(100);
////						
////						click(admin, 10);
////						Thread.sleep(300);
////						if (previousEntity2 != null) {
////							int timeLimit = 6000;
////							int timer = 0;
////							
////							while (true) {
////								
////								if(!previousEntity2.getLegalFirstName().equals(staffInfoPage.getLegalFirstName().getAttribute("value"))) {
////									
////									break;
////								}				
////								Thread.sleep(200);				
////								timer = timer + 200;
////								if (timer > timeLimit) {
////									break;
////								} 
////							}
////						}
////											
////						
////					
////						Staff adminInfo = staffInfoPage.getStaffInfo();
////						previousEntity2 = adminInfo;
////						adminInfo.setSchoolDistrictInfo(schoolDistrictInfo);
////						adminInfo.setSchoolName(schoolName);
////						admins.add(adminInfo);
////						System.out.println("Stuff's Admins demographic Info -->>>" + adminInfo);
////					}
////					allAdmins.addAll(admins);
////
//					driver.switchTo().defaultContent();
//					driver.switchTo().frame(iFrameNavigator);
////
//				}
//
//				schoolDistrictStaff.setTeachers(allTeachers);
//				schoolDistrictStaff.setPrincipal(allPrincipals);
//				schoolDistrictStaff.setAdmins(allAdmins);
//				
//				schoolDistrictExpandButton.click();
//				//schoolDistrictsExpandButtons.get(i).click();
//				
//				
//			}
//			
//			if (++counter == numberOfSchoolDistricts) {
//				return schoolDistrictStaff;
//			}
//			countyExpandButtons.get(t).click();
//			//countyExpandButton.click();
//		}
//
//		return schoolDistrictStaff;
//	}
//
//	public SchoolDistrictStaff getSchoolDistrictStaffV2(int numberOfSchoolDistricts) throws InterruptedException {
//
//		SchoolDistrictStaff schoolDistrictStaff2 = new SchoolDistrictStaff();
//		loginToV2();
//
//		sleep(1);
//
//		List<Staff> allTeachers = new ArrayList<>();
//		List<Staff> allPrincipals = new ArrayList<>();
//		List<Staff> allAdmins = new ArrayList<>();
//
//		Select districtDropDownList = new Select(driver
//				.findElement(By.xpath("//select[@class= 'border customStyle w-100 select-in-nav border-secondary']")));
//
//		page.administration.click();
//		Thread.sleep(200);
//
//		page.manageUsers.click();
//		Thread.sleep(200);
//
//		int counter = 0;
//		for (int i = 0; i < districtDropDownList.getOptions().size(); i++) {
//			districtDropDownList.selectByIndex(i);
//
//			Thread.sleep(2);
//
//			Select activeInactive = new Select(
//					driver.findElement(By.xpath("//select[@class='border w-100 manage-user-cb']")));
//			activeInactive.selectByVisibleText("Active/Inactive");
//
//			sleep(1);
//			Select role = new Select(
//					driver.findElement(By.xpath("//select[@class= 'border w-100 manage-user-cb mt-3']")));
//			role.selectByVisibleText("Nurse");
//
//			StaffInfoPage2 staffInfoPage2 = new StaffInfoPage2(driver);
//
//			List<Staff> teachers = new ArrayList<>();
//
//			WebElement table = driver.findElement(By.tagName("tbody"));
//
//			List<WebElement> listOfNurses = table.findElements(By.tagName("tr"));
////			System.out.println(listOfNurses.size());
////			for (WebElement teacher : listOfNurses) {
////				teacher.click();
////				Thread.sleep(200);
////				if (driver.findElement(By.xpath(
////						"//*[@id=\"app\"]/div/div/div/div/div/div/div/fieldset/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td"))
////						.getText().equalsIgnoreCase("There is no data to display")) {
////					continue;
////				} else {
////					Staff teacherInfo = staffInfoPage2.getStaffInfo();
////					teachers.add(teacherInfo);
////					System.out.println("This is tachers info --->>> " + teacherInfo);
////
////				}
////				allTeachers.addAll(teachers);
////
////			}
//			role.selectByVisibleText("School Administrator");
//
//			List<Staff> principals = new ArrayList<>();
//
//			List<WebElement> listOfprincipals = table.findElements(By.tagName("tr"));
//			for (WebElement principal : listOfprincipals) {
//				principal.click();
//				Thread.sleep(200);
//				if (driver.findElement(By.xpath(
//						"//*[@id=\"app\"]/div/div/div/div/div/div/div/fieldset/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td"))
//						.getText().equalsIgnoreCase("There is no data to display")) {
//					continue;
//				} else {
//					Staff principalInfo = staffInfoPage2.getStaffInfo();
//					// principalInfo.setSchoolDistrictInfo(schoolDistrictinfo);
//					principals.add(principalInfo);
//
//					System.out.println("This is princal Info --->>> " + principalInfo);
//				}
//				allPrincipals.addAll(principals);
//			}
//			role.selectByVisibleText("IT Administrator");
//			List<Staff> itAdmins = new ArrayList<>();
//			List<WebElement> listOfItAdmins = table.findElements(By.tagName("tr"));
//
//			for (WebElement itAdmin : listOfItAdmins) {
//				itAdmin.click();
//				Thread.sleep(200);
//				if (driver.findElement(By.xpath(
//						"//*[@id=\"app\"]/div/div/div/div/div/div/div/fieldset/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td"))
//						.isDisplayed()) {
//					continue;
//				} else {
//					Staff itAdminsInfo = staffInfoPage2.getStaffInfo();
//					itAdmins.add(itAdminsInfo);
//
//					System.out.println("this is a It Admins info -->>> " + itAdminsInfo);
//
//				}
//				allAdmins.addAll(itAdmins);
//			}
//
//			schoolDistrictStaff2.setTeachers(allTeachers);
//			schoolDistrictStaff2.setPrincipal(allPrincipals);
//			schoolDistrictStaff2.setAdmins(allAdmins);
//
//		}
//		return schoolDistrictStaff2;
//	}
//
//	public SchoolDistrictsStudent getSchoolStudentsV1( int numberOfSchoolDistricts) throws Exception {
//	
//		loginToV1("innerlinkURl","ibxUserName","ibxPassword");
//
//		SchoolDistrictsStudent schoolDistrictsStudent = new SchoolDistrictsStudent();
//		int counter = 0;
//		WebElement innerLinkExpandButton = innerLinkPage.getInnerLinkExpandButtons();
//		innerLinkExpandButton.click();
//
//		Thread.sleep(200);
//
//		List<WebElement> countyExpandButtons = innerLinkPage.getCountyExpandButtons();
//
//		System.out.println("The County size ---> " + countyExpandButtons.size());
//		//for (WebElement countyExpandBtn : countyExpandButtons) {
//		for (int t = 1; t < 2; t++) {
//			
//			countyExpandButtons.get(t).click();
//			//countyExpandBtn.click();
//
//			
////			List<WebElement> schoolDistrictsExpandButtons = innerLinkPage
////					.getSchoolDistrictExpandButtons(countyExpandBtn);
//			List<WebElement> schoolDistrictsExpandButtons = innerLinkPage
//					.getSchoolDistrictExpandButtons(countyExpandButtons.get(t));
//			
//			
//			System.out.println("The School Distric size in a County ---> " + schoolDistrictsExpandButtons.size());
//
//			List<Student> allStudents = new ArrayList<>();
//
//			 //for (WebElement schoolDistrictExpandBtn : schoolDistrictsExpandButtons) {
//			for (int i = 0; i <3 ; i++) {
//				// if(schoolDistrictExpandBtn.equals(schoolDistrictName)) {
//				 
//				
//				 
//				//SchoolDistrict schoolDistrictStudents = new SchoolDistrict();
//
//				// schoolDistrictExpandBtn.click();
//				schoolDistrictsExpandButtons.get(i).click();
//				 //}
////				 WebElement schoolDistrictLink =
////				 innerLinkPage.getSchoolDistrictLink(schoolDistrictExpandBtn);
//				WebElement schoolDistrictLink = innerLinkPage
//						.getSchoolDistrictLink(schoolDistrictsExpandButtons.get(i));
//
//				String schoolDistrictInfo = schoolDistrictLink.getText();
//				click(schoolDistrictLink, 10);
//				//schoolDistrictLink.click();
//
//				List<WebElement> schoolsLinks = innerLinkPage.getSchoolsLinks(schoolDistrictLink);
//				System.out.println("School size in a District---> " + schoolsLinks.size());
//				// List<Student> students = new ArrayList<>();
//
//				for (WebElement schoolLink : schoolsLinks) {
//				//for (int s = 0; s < 1; s++) {
//					
//					String schoolName = schoolLink.getText();
//
//					//String schoolName = schoolsLinks.get(s).getText();
//					schoolLink.click();
//
//					//schoolsLinks.get(s).click();
//					Thread.sleep(200);
//					driver.switchTo().defaultContent();
//
//					// Clicking on Student tab
//					page.student.click();
//					Thread.sleep(200);
//					driver.switchTo().frame(iFrameEditorWin);
//
//					// Select status
//					Select statusDropDown = new Select(driver.findElement(By.name("state")));
//					statusDropDown.selectByVisibleText("Active");
//					Thread.sleep(200);
//					page.searchBtn.click();
//
//					sleep(2);
//
//					StudentInfoPage studentInfoPage = new StudentInfoPage(driver);
//					List<Student> students = new ArrayList<>();
//					// Getting list of Students
//				
//					int listOfStudents= page.listOfStudents.size();
//
//					Student previousEntity=null;
//					//for (WebElement eachStudent : page.listOfStudents) {
//					
//					
//					
//					for (int j = 0; j < listOfStudents; j++) {
//
//					
//						page.listOfStudents.get(j).click();
//						
//						 //eachStudent.click();
//						Thread.sleep(300);
//						
//						if (previousEntity != null) {
//							int timeLimit = 6000;
//							int timer = 0;
//							
//							while (true) {
//								
//								if(!previousEntity.getLegalFirstName().equals(studentInfoPage.getLegalFirstName().getAttribute("value"))) {
//									
//									break;
//								}				
//								Thread.sleep(100);				
//								timer = timer + 100;
//								if (timer > timeLimit) {
//									break;
//								} 
//							}
//						}
//							
//						Student studentInfo = studentInfoPage.getStudentInfo();
//						previousEntity = studentInfo;
//						studentInfo.setSchoolDistrictInfo(schoolDistrictInfo);
//						studentInfo.setSchoolName(schoolName);
//						students.add(studentInfo);
//						System.out.println("Student's info --->>" + studentInfo);
//					}
//					allStudents.addAll(students);
//
//					driver.switchTo().defaultContent();
//					driver.switchTo().frame(iFrameNavigator);
//				}
//				schoolDistrictsStudent.setStudents(allStudents);
//				schoolDistrictsStudent.setSchoolDistrictName(schoolDistrictInfo);
//
//				// schoolDistrictExpandBtn.click();
//				schoolDistrictsExpandButtons.get(i).click();
//
//				if (++counter == numberOfSchoolDistricts) {
//
//					return schoolDistrictsStudent;
//				}
//			}
//			
//			countyExpandButtons.get(t).click();
//			//countyExpandBtn.click();
//			
//			
//		}
//		return schoolDistrictsStudent;
//	}
//
//	public SchoolDistrictsStudent getSchoolStudentsV2(int numberOfSchoolDistricts) throws Exception {
//
//		SchoolDistrictsStudent schoolDistrictStudents = new SchoolDistrictsStudent();
//
//		loginToV2();
//
//		sleep(1);
//
//		List<Student> allStudents = new ArrayList<>();
//
//		Select districtDropDownList = new Select(driver
//				.findElement(By.xpath("//select[@class= 'border customStyle w-100 select-in-nav border-secondary']")));
//
//		int counter = 0;
//		for (int i = 0; i < 1/*districtDropDownList.getOptions().size()*/; i++) {
//			districtDropDownList.selectByIndex(i);
//			Thread.sleep(200);
//
//			Select schoolDropDowmList = new Select(driver.findElement(
//					By.xpath("//select[@class= 'border customStyle w-100 select-in-nav border-secondary mt-1']")));
//			Thread.sleep(500);
//			page.administration.click();
//
//			Thread.sleep(500);
//
//			page.manageStudents.click();
//
//			for (int j = 0; j <2 /*schoolDropDowmList.getOptions().size()*/; j++) {
//				schoolDropDowmList.selectByIndex(j);
//
//				// driver.findElement(By.xpath("//a[@class='dropdown-toggle nav-link
//				// dropdown-text-nav']")).click();
//
//				Thread.sleep(500);
//
//				StudentInfoPage2 studentInfoPage2 = new StudentInfoPage2(driver);
//
//				List<Student> students = new ArrayList<>();
//
//				// WebElement table = driver.findElement(By.xpath("//table[@class='table
//				// table-striped table-hover']"));
//
//				List<WebElement> listOfStudents = driver
//						.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr"));
//				sleep(2);
//				System.out.println(listOfStudents.size());
//
//				//for (WebElement student : listOfStudents) {
//					for (int k = 0;k < 2; k++) {
//
//						System.out.println(driver.findElements(By.tagName("td")).get(k).getText());
//						//student.findElements(By.tagName("td")).get(k).click();
//						listOfStudents.get(k).click();
//
//						Student teacherInfo = studentInfoPage2.getStudentInfo();
//						students.add(teacherInfo);
//						System.out.println("This is students info --->>> " + teacherInfo);
//						
//					}
//					allStudents.addAll(students);
//				//}
//			
//				}
//			schoolDistrictStudents.setStudents(allStudents);
//			if (++counter == numberOfSchoolDistricts) {
//				return schoolDistrictStudents;
//			}
//
//		}
//		return schoolDistrictStudents;
//	}
//}
