package com.Admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.Service.Impl.PoojeService;
import com.Admin.bean.Donation;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.Income;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;
import com.Admin.bean.Reportbean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.validator.DonationValidator;
import com.Admin.validator.ExpenseValidator;
import com.Admin.validator.IncomeValidator;
import com.Admin.validator.PoojeValidator;
import com.Admin.validator.RegistrationValidator;
import com.Admin.validator.SashwathaPoojeValidator;
import com.Brahmalingeshwara.kanajartemple.Utills;

@Controller
@RequestMapping(value = "/Admin")
public class AdminController {

	public static String REDIRECTPREFIX = "redirect:";

	@Autowired
	PoojeService service;

	@Autowired
	private kanajarTempleMethods defaultTempleMethods;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private PoojeValidator poojeValidator;

	@Autowired
	private SashwathaPoojeValidator sashwathaPoojeValidator;

	@Autowired
	private DonationValidator donationValidator;

	@Autowired
	private IncomeValidator incomeValidator;

	@Autowired
	private ExpenseValidator expenseValidator;

	@RequestMapping(value = "/PoojeReceipt/{PoojeId}")
	public ModelAndView AdminPoojeReceipt(@PathVariable("PoojeId") String Poojeid, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/PoojeReciept");
		mv.addObject("Pooje", defaultTempleMethods.getPooje(Poojeid));
		mv.addObject(new Poojebean());
		return mv;
	}

	@RequestMapping(value = "/AddPoojeReceipt")
	public String AdmimAddPoojeReceipt(@ModelAttribute Poojebean pbean, HttpServletRequest req,
			HttpServletResponse response, BindingResult bindingResult, Model model) throws IOException {

		poojeValidator.validate(pbean, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("Pooje", defaultTempleMethods.getPooje(pbean.getPid().toString()));
			model.addAttribute(pbean);
			return "admin/PoojeReciept";
		} else {
			String RNO = service.getPoojedetailstoprint(pbean);
			String PID = pbean.getPid().toString();
			return REDIRECTPREFIX + "/Admin/AddPoojeReceipt/" + PID + "/" + RNO;
		}

	}

	@RequestMapping(value = "/AddPoojeReceipt/{PoojeID}/{RecNo}")
	public ModelAndView AdminAddPoojeReceipt(@PathVariable("PoojeID") String PoojeID,
			@PathVariable("RecNo") String RecNo, HttpServletRequest req) {

		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView("admin/Pooje");
		return addPooje(session, RecNo, PoojeID, mv);
	}

	@RequestMapping(value = "/EditPooje/{PoojeID}/{RecNo}")
	public ModelAndView EditPooje(@PathVariable("PoojeID") String PoojeID, @PathVariable("RecNo") String RecNo,
			HttpServletRequest req) {

		ModelAndView mv = new ModelAndView("admin/PoojeEdit");
		mv.addObject(new Poojebean());
		return getPoojeDetails(mv, PoojeID, RecNo);
	}

	@RequestMapping(value = "/UpdatePooje")
	public ModelAndView UpdatePooje(@ModelAttribute Poojebean pbean, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult, Locale locale) {

		poojeValidator.validate(pbean, bindingResult);
		String PoojeID = pbean.getPid().toString();
		String RNO = pbean.getRecNo().toString();
		ModelAndView mv = new ModelAndView("admin/PoojeEdit");

		if (bindingResult.hasErrors()) {
			mv.addObject(pbean);
			return getPoojeDetails(mv, PoojeID, RNO);

		} else {
			Integer i = service.updatePooje(pbean);
			if (i == 1) {
				mv.addObject("message", messageSource.getMessage("update.success", null, locale));
				mv.addObject(new Poojebean());
				return getPoojeDetails(mv, PoojeID, RNO);
			}
			return null;
		}
	}

	@RequestMapping(value = "/PoojeReceiptList/{PoojeID}")
	public ModelAndView AdminPoojeReceiptList(@PathVariable("PoojeID") String PoojeID, HttpServletRequest request,
			HttpServletResponse response, Pooje pbean) {

		ModelAndView mv = new ModelAndView("admin/PoojeReceiptList");

		mv.addObject("PoojeDetails", defaultTempleMethods.getPoojeDataDetail(PoojeID));
		mv.addObject("PoojeName", defaultTempleMethods.getPooje(PoojeID).getPoojeName());
		return mv;
	}

	@RequestMapping(value = "/PoojeReport")
	public ModelAndView AdminPoojeReport(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/PoojeReport");
		mv.addObject("PoojeDetails", defaultTempleMethods.getPooje());
		return mv;
	}

	@RequestMapping(value = "/PoojeReportSuccess")
	public ModelAndView AdminPoojeReportSuccess(HttpServletRequest request, HttpServletResponse response,
			Reportbean rbean) {

		List<?> PoojeReceipt = service.getPoojeReport(rbean);

		JRDataSource datasource = new JRBeanCollectionDataSource(PoojeReceipt);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);

		ModelAndView mv = new ModelAndView("PoojeReport", parameterMap);
		mv.addObject("format", rbean.getSaveAs());
		return mv;
	}

	@RequestMapping(value = "/SashwathaPooje")
	public ModelAndView AdminSashwathaPooje(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/SashwathaPooje");
		mv.addObject("Pooje", defaultTempleMethods.getPooje("1"));
		mv.addObject(new SashwathaPoojebean());
		return mv;
	}

	@RequestMapping(value = "/SashwathaPoojeReceipt")
	public String AdminSashwathaPoojeReceipt(@ModelAttribute SashwathaPoojebean sbean, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult, Model model) throws IOException {
		sashwathaPoojeValidator.validate(sbean, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("Pooje", defaultTempleMethods.getPooje(sbean.getPid().toString()));
			model.addAttribute(sbean);
			return "admin/SashwathaPooje";
		} else {
			String RNO = service.getSashwathaPoojedetailstoprint(sbean).toString();
			String PID = sbean.getPid().toString();
			return REDIRECTPREFIX + "/Admin/SashwathaPoojeReceipt/" + PID + "/" + RNO;
		}

	}

	@RequestMapping(value = "/EditSashwathaPooje/{RecNo}")
	public ModelAndView EditSashwathaPooje(@PathVariable("RecNo") String RecNo, HttpServletRequest req) {

		ModelAndView mv = new ModelAndView("admin/SashwathaPoojeEdit");

		mv.addObject(new SashwathaPoojebean());
		return getSashhwathaDetails(mv, RecNo);
	}

	@RequestMapping(value = "/UpdateSashwathaPooje")
	public ModelAndView UpdateSashwathaPooje(@ModelAttribute SashwathaPoojebean sbean, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult, Locale locale) {

		sashwathaPoojeValidator.validate(sbean, bindingResult);
		ModelAndView mv = new ModelAndView("admin/SashwathaPoojeEdit");
		String RNO = sbean.getRecNo().toString();
		if (bindingResult.hasErrors()) {
			mv.addObject(sbean);
			return getSashhwathaDetails(mv, RNO);

		} else {
			Integer i = service.updateSashwathaPooje(sbean);
			if (i == 1) {
				mv.addObject("message", messageSource.getMessage("update.success", null, locale));
				mv.addObject(new SashwathaPoojebean());
				return getSashhwathaDetails(mv, RNO);
			}
			return null;
		}

	}

	@RequestMapping(value = "/SashwathaPoojeReceiptList")
	public ModelAndView AdminSashwathaPoojeReceiptList(HttpServletRequest request, HttpServletResponse response,
			Pooje pbean) {

		ModelAndView mv = new ModelAndView("admin/PoojeReceiptList");
		mv.addObject("PoojeDetails", defaultTempleMethods.getSashwathaPooje());
		mv.addObject("PoojeName", "SashwathaPooje");
		return mv;
	}

	@RequestMapping(value = "/SashwathaPoojeReceipt/{PoojeID}/{RecNo}")
	public ModelAndView AdminSashwathaPoojeReceipt(@PathVariable("PoojeID") String PoojeID,
			@PathVariable("RecNo") String RecNo, HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("admin/sashwathareciept");
		return addSashwathaPooje(session, RecNo, PoojeID, mv);
	}

	@RequestMapping(value = "/SashwathaPoojeReport")
	public ModelAndView AdminSashwathaPoojeReport(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("admin/SashwathaPoojeReport");
		return mv;
	}

	@RequestMapping(value = "/SashwathaPoojeReportSuccess")
	public ModelAndView AdminSashwathaPoojeReportSuccess(HttpServletRequest request, HttpServletResponse response,
			Reportbean rbean) {

		List<?> PoojeReceipt = service.getSashwathaReport(rbean);

		JRDataSource datasource = new JRBeanCollectionDataSource(PoojeReceipt);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);

		ModelAndView mv = new ModelAndView("SashwathaReport", parameterMap);
		mv.addObject("format", rbean.getSaveAs());
		return mv;
	}

	@RequestMapping(value = "/income", method = RequestMethod.GET)
	public ModelAndView AdminAddIncome(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("admin/Income");
		mv.addObject("IncomeDetails", defaultTempleMethods.getIncome());
		mv.addObject(new IncomeData());
		return mv;
	}

	@RequestMapping(value = "/income", method = RequestMethod.POST)
	public String AdminAddIncomeSuccess(HttpServletResponse response,
			@ModelAttribute IncomeData ibean, Model mv, BindingResult bindingResult, Locale locale) {

		incomeValidator.validate(ibean, bindingResult);
		if (bindingResult.hasErrors()) {
			mv.addAttribute(ibean);
		} else {
			Integer RecNo = service.addincome(ibean);
			if (RecNo == null) {
				mv.addAttribute(new IncomeData());
				mv.addAttribute("message", messageSource.getMessage("message.error", null, locale));
			} else {
				return REDIRECTPREFIX + "/Admin/AddIncome/" + ibean.getIid() + "/" + RecNo;
			}
		}
		mv.addAttribute("IncomeDetails", defaultTempleMethods.getIncome());
		return "admin/Income";
	}

	@RequestMapping(value = "/AddIncome/{IncomeID}/{RecNo}")
	public ModelAndView AdminAddINcome(@PathVariable("IncomeID") String IncomeID, @PathVariable("RecNo") String RecNo,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("admin/IncomeReciept");
		return addIncome(session, IncomeID, RecNo, mv);

	}

	@RequestMapping(value = "/EditIncome/{IncomeID}/{RecNo}")
	public ModelAndView editIncome(@PathVariable("IncomeID") String IncomeID,@PathVariable("RecNo") String RecNo, HttpServletRequest req) {

		ModelAndView mv = new ModelAndView("admin/IncomeEdit");
		mv.addObject("Data", defaultTempleMethods.getIncomeData(RecNo, IncomeID));
		mv.addObject(new IncomeData());
		return mv;
	}

	@RequestMapping(value = "/UpdateIncome")
	public ModelAndView updateIncome(@ModelAttribute IncomeData ibean, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult, Locale locale) {

		incomeValidator.validate(ibean, bindingResult);
		ModelAndView mv = new ModelAndView("admin/IncomeEdit");
		
		if (bindingResult.hasErrors()) {
			mv.addObject(ibean);
			mv.addObject("Data", defaultTempleMethods.getIncomeData(ibean.getRecNo().toString(),ibean.getIid().toString()));
			return mv;
		} else {
			Integer i = service.updateIncome(ibean);
			if (i == 1) {
				mv.addObject("Data", defaultTempleMethods.getIncomeData(ibean.getRecNo().toString(),ibean.getIid().toString()));
				mv.addObject("message", messageSource.getMessage("update.success", null, locale));
				mv.addObject(new IncomeData());
				return mv;
			}
			return null;
		}
	}

	@RequestMapping(value = "/IncomeList/{IncomeID}")
	public ModelAndView AdminIncomeList(@PathVariable("IncomeID") String IncomeID, HttpServletResponse response, Poojebean pbean) {

		ModelAndView mv = new ModelAndView("admin/IncomeList");
		mv.addObject("IncomeDetails", defaultTempleMethods.getIncomeData(IncomeID));

		return mv;
	}

	@RequestMapping(value = "/IncomeReport")
	public ModelAndView AdminIncomeReport(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("admin/IncomeReport");
		return mv;
	}

	@RequestMapping(value = "/IncomeReportSuccess")
	public ModelAndView AdminIncomeReportSuccess(HttpServletRequest request, HttpServletResponse response,
			Reportbean rbean) {
		List<?> PoojeReceipt = service.getIncomeReport(rbean);

		JRDataSource datasource = new JRBeanCollectionDataSource(PoojeReceipt);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);

		ModelAndView mv = new ModelAndView("IncomeReport", parameterMap);
		mv.addObject("format", rbean.getSaveAs());
		return mv;
	}

	@RequestMapping(value = "/Donation")
	public ModelAndView AdminDonation(HttpServletRequest req) {

		ModelAndView mv = new ModelAndView("admin/Donation");
		mv.addObject("DonationDetails", defaultTempleMethods.getDonation());
		mv.addObject(new DonationDetail());
		return mv;
	}

	@RequestMapping(value = "/DonationReceipt")
	public String AdminDonationReceipt(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute DonationDetail dbean, BindingResult bindingResult, Model model) {

		donationValidator.validate(dbean, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("DonationDetails", defaultTempleMethods.getDonation());
			model.addAttribute(dbean);
			return "admin/Donation";
		} else {
			String RNO = service.getDonationReceipt(dbean);
			String DID = dbean.getDid().toString();
			return REDIRECTPREFIX + "/Admin/DonationReceipt/" + DID + "/" + RNO;
		}
	}

	@RequestMapping(value = "/EditDonation/{DonationID}/{RecNo}")
	public ModelAndView EditDonation(@PathVariable("DonationID") String DonationID, @PathVariable("RecNo") String RecNo,
			HttpServletRequest req) {

		ModelAndView mv = new ModelAndView("admin/DonationEdit");
		mv.addObject(new DonationDetail());
		return getDonationDetails(mv, DonationID, RecNo);
	}

	@RequestMapping(value = "/UpdateDonation")
	public ModelAndView UpdateDonation(@ModelAttribute DonationDetail dbean, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult, Locale locale) {

		donationValidator.validate(dbean, bindingResult);
		String DonationID = dbean.getDid().toString();
		String RecNo = dbean.getRecNO().toString();
		ModelAndView mv = new ModelAndView("admin/DonationEdit");

		if (bindingResult.hasErrors()) {
			mv.addObject(dbean);
			return getDonationDetails(mv, DonationID, RecNo);

		} else {
			Integer i = service.updateDonation(dbean);
			if (i == 1) {
				mv.addObject("message", messageSource.getMessage("update.success", null, locale));
				mv.addObject(new DonationDetail());
				return getDonationDetails(mv, DonationID, RecNo);
			}
			return null;
		}
	}

	@RequestMapping(value = "/DonationReceipt/{DonationID}/{RecNo}")
	public ModelAndView AdminDonationReceipt(@PathVariable("DonationID") String DonationID,
			@PathVariable("RecNo") String RecNo, HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("admin/DonationReciept");
		return addDonation(session, RecNo, DonationID, mv);

	}

	@RequestMapping(value = "/DonationReceiptList/{DonationID}")
	public ModelAndView AdminDonationReceiptList(@PathVariable("DonationID") String DonationID,
			HttpServletRequest request, HttpServletResponse response, Donation dbean) {

		ModelAndView mv = new ModelAndView("admin/DonationList");
		List<?> PoojeDetails = defaultTempleMethods.getDonationDataDetail(DonationID);
		mv.addObject("PoojeDetails", PoojeDetails);
		mv.addObject("DonationName", defaultTempleMethods.getDonation(DonationID).getDonationName());
		return mv;
	}

	@RequestMapping(value = "/DonationReport")
	public ModelAndView AdminDonationReport(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/DonationReport");
		List<?> DonationDetails = defaultTempleMethods.getDonation();

		mv.addObject("DonationDetails", DonationDetails);
		return mv;
	}

	@RequestMapping(value = "/DonationReportSuccess")
	public ModelAndView AdminDonationReportSuccess(HttpServletRequest request, HttpServletResponse response,
			Reportbean rbean) {
		Donation donation = defaultTempleMethods.getDonation(rbean.getDid());
		List<?> DonationReport = service.getDonationReport(rbean, donation.getDonationName());

		JRDataSource datasource = new JRBeanCollectionDataSource(DonationReport);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);

		ModelAndView mv = new ModelAndView("DonationReport", parameterMap);
		mv.addObject("format", rbean.getSaveAs());
		return mv;
	}

	@RequestMapping(value = "/Expenditure")
	public ModelAndView AdminExpenditure(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/Expenses");
		mv.addObject(new ExpenseData());
		return mv;
	}

	@RequestMapping(value = "/ExpenditureReceipt")
	public String AdminExpenditureReceipt(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute ExpenseData ebean, BindingResult bindingResult, Model mv) throws IOException {

		expenseValidator.validate(ebean, bindingResult);
		if (bindingResult.hasErrors()) {
			mv.addAttribute(ebean);
			return "admin/Expenses";
		} else {
			String RNO = service.getExpenditureReceipt(ebean);
			return REDIRECTPREFIX + "/Admin/ExpenditureReceipt/" + RNO;
		}

	}

	@RequestMapping(value = "/ExpenditureReceipt/{ExpenseID}/{RecNo}")
	public ModelAndView AdminExpenditureReceipt(@PathVariable("ExpenseID") String ExpenseID,@PathVariable("RecNo") String RecNo, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("admin/ExpenseReciept");
		return addExpense(session,ExpenseID,RecNo, mv);
	}

	@RequestMapping(value = "/EditExpense/{ExpenseID}/{RecNo}")
	public ModelAndView EditExpense(@PathVariable("ExpenseID") String ExpenseID,@PathVariable("RecNo") String RecNo, HttpServletRequest req) {

		ModelAndView mv = new ModelAndView("admin/ExpenseEdit");
		mv.addObject("Data", defaultTempleMethods.getExpenditure(RecNo));
		mv.addObject(new ExpenseData());
		return mv;
	}

	@RequestMapping(value = "/UpdateExpense")
	public ModelAndView UpdateExpense(@ModelAttribute ExpenseData ebean, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult, Locale locale) {
		expenseValidator.validate(ebean, bindingResult);
		ModelAndView mv = new ModelAndView("admin/ExpenseEdit");
		if (bindingResult.hasErrors()) {
			mv.addObject("Data", defaultTempleMethods.getExpenditure(ebean.getRecNo().toString()));
			mv.addObject(ebean);
			return mv;
		} else {
			Integer i = service.updateExpense(ebean);
			if (i == 1) {
				mv.addObject("message", messageSource.getMessage("update.success", null, locale));
				mv.addObject("Data", defaultTempleMethods.getExpenditure(ebean.getRecNo().toString()));
				mv.addObject(new ExpenseData());
				return mv;
			}
			return null;
		}
	}

	@RequestMapping(value = "/ExpenditureList")
	public ModelAndView AdminExpenditureList(HttpServletRequest request, HttpServletResponse response,
			Poojebean pbean) {

		ModelAndView mv = new ModelAndView("admin/ExpenseList");
		List<?> PoojeDetails = defaultTempleMethods.getExpenditure();
		mv.addObject("PoojeDetails", PoojeDetails);

		return mv;
	}

	@RequestMapping(value = "/ExpenditureReport")
	public ModelAndView AdminExpenditureReport(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/ExpenditureReport");

		return mv;
	}

	@RequestMapping(value = "/ExpenditureReportSuccess")
	public ModelAndView AdminExpenditureReportSuccess(HttpServletRequest request, HttpServletResponse response,
			Reportbean rbean) {
		List<?> DonationReport = service.getExpenditureReport(rbean);

		JRDataSource datasource = new JRBeanCollectionDataSource(DonationReport);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);

		ModelAndView mv = new ModelAndView("ExpenditureReport", parameterMap);
		mv.addObject("format", rbean.getSaveAs());
		return mv;
	}

	@RequestMapping(value = "/AllReport")
	public ModelAndView AdminAllReport(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/AllReport");

		return mv;
	}

	@RequestMapping(value = "/AllReportSuccess")
	public ModelAndView AdminAllReportSuccess(HttpServletRequest request, HttpServletResponse response,
			Reportbean rbean) {
		List<?> DonationReport = service.getAllReport(rbean);
		JRDataSource datasource = new JRBeanCollectionDataSource(DonationReport);
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);
		ModelAndView mv = new ModelAndView("AllReport", parameterMap);
		mv.addObject("format", rbean.getSaveAs());
		return mv;
	}

	public ModelAndView addPooje(HttpSession session, String RecNo, String PoojeID, ModelAndView mv) {

		Pooje pooje = defaultTempleMethods.getPooje(PoojeID);
		Poojebean poojedata = defaultTempleMethods.getPoojeDataDetail(RecNo, PoojeID);
		mv.addObject("Pooje", pooje);
		mv.addObject("PoojeData", poojedata);

		Double Amount = pooje.getAmount() * poojedata.getQuantity();
		mv.addObject("InWords", Utills.converttoword(Amount.intValue()) + " only");
		mv.addObject("Amount", Amount.intValue() + "/-");
		mv.addObject("Signature", session.getAttribute("FullName"));
		mv.addObject("tdate", getTdate(poojedata.getBDate()));
		return mv;

	}

	public ModelAndView addSashwathaPooje(HttpSession session, String RecNo, String PoojeID, ModelAndView mv) {
		Pooje pooje = defaultTempleMethods.getPooje(PoojeID);
		SashwathaPoojebean poojedata = defaultTempleMethods.getSashwathaPooje(RecNo);
		mv.addObject("Pooje", pooje);
		mv.addObject("PoojeData", poojedata);
		int Amount = pooje.getAmount().intValue();
		mv.addObject("InWords", Utills.converttoword(Amount) + " only");
		mv.addObject("Amount", Amount + "/-");
		mv.addObject("Signature", session.getAttribute("FullName"));
		mv.addObject("tdate", getTdate(poojedata.getBdate()));
		return mv;
	}

	public ModelAndView addDonation(HttpSession session, String RecNo, String DonationID, ModelAndView mv) {
		Donation donation = defaultTempleMethods.getDonation(DonationID);
		DonationDetail donationdata = defaultTempleMethods.getDonationDataDetail(RecNo, DonationID);
		mv.addObject("Donation", donation);
		mv.addObject("DonationData", donationdata);
		int Amount = donationdata.getAmount().intValue();
		mv.addObject("InWords", Utills.converttoword(Amount) + " only");
		mv.addObject("Amount", Amount + "/-");
		mv.addObject("Signature", session.getAttribute("FullName"));
		mv.addObject("tdate", getTdate(donationdata.getBdate()));
		return mv;

	}

	public ModelAndView addExpense(HttpSession session,String ExpenseID, String RecNo, ModelAndView mv) {
		ExpenseData expense = defaultTempleMethods.getExpenditureData(RecNo,ExpenseID);

		mv.addObject("Expense", expense);

		int Amount = expense.getAmount().intValue();
		mv.addObject("InWords", Utills.converttoword(Amount) + " only");
		mv.addObject("Amount", Amount + "/-");
		mv.addObject("Signature", session.getAttribute("FullName"));
		mv.addObject("tdate", getTdate(expense.getBDate()));
		return mv;
	}

	public ModelAndView addIncome(HttpSession session, String IncomeID, String RecNo, ModelAndView mv) {

		if (RecNo != null && IncomeID != null) {
			Income income=defaultTempleMethods.getIncome(IncomeID);
			IncomeData incomeData = defaultTempleMethods.getIncomeData(RecNo,IncomeID);
			mv.addObject("Income", incomeData);
			int Amount = incomeData.getAmount().intValue();
			mv.addObject("InWords", Utills.converttoword(Amount) + " only");
			mv.addObject("Amount", Amount + "/-");
			mv.addObject("IncomeName",income.getIncomeName());
			mv.addObject("Signature", session.getAttribute("FullName"));
			mv.addObject("tdate", getTdate(incomeData.getBdate()));
			return mv;
		}
		return null;
	}

	private String getTdate(Timestamp timestamp) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yy hh:mm a");
		return dateformat.format(timestamp);
	}

	private ModelAndView getDonationDetails(ModelAndView mv, String DID, String RNO) {
		mv.addObject("Donation", defaultTempleMethods.getDonation(DID));
		mv.addObject("Data", defaultTempleMethods.getDonationDataDetail(RNO, DID));
		return mv;
	}

	private ModelAndView getSashhwathaDetails(ModelAndView mv, String RNO) {
		mv.addObject("Pooje", defaultTempleMethods.getPooje("1"));
		mv.addObject("Data", defaultTempleMethods.getSashwathaPooje(RNO));
		return mv;
	}

	private ModelAndView getPoojeDetails(ModelAndView mv, String PID, String RNO) {
		mv.addObject("Pooje", defaultTempleMethods.getPooje(PID));
		mv.addObject("Data", defaultTempleMethods.getPoojeDataDetail(RNO, PID));
		return mv;
	}

}
