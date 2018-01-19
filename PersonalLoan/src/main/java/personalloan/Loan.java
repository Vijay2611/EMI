package personalloan;

import java.util.*;
import java.lang.*;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Loan implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   private java.lang.Double loan_customer_applied_amount;
   private java.lang.Integer loan_customer_applied_tenure;
   private java.lang.Double loan_system_eligible_loan_amount;
   private java.lang.Double loan_system_approved_roi;
   private java.lang.Integer loan_system_approved_tenure;
   private java.lang.Double loan_max_emi_allowed_abb;
   private java.lang.Double loan_max_emi_allowed_foir;

   private java.lang.Double loan_customer_applied_emi;

   private java.util.List<java.lang.Double> loan_amount_from_multiplier;

   private Integer loan_multiplier;

   private java.lang.Integer loan_multiplier_list;

   private java.lang.Integer loan_moratorium_period = 0;

   @org.kie.api.definition.type.Label("0-simple interest, 1-compound interest")
   private java.lang.Integer loan_moratorium_interest_type = 0;

   @org.kie.api.definition.type.Label("0-No,1-yes")
   private java.lang.Integer loan_is_interest_paid_during_moratorium_period = 0;

   private java.util.List<java.lang.Double> loan_amount_from_servicibility;

   private java.util.List<java.lang.Double> loan_amount_from_abb;

   private java.lang.Double loan_amount_from_product_cap;

   private java.lang.String loan_quotes;

   private java.lang.Double loan_max_tenure_amount_from_servicibility;

   private java.lang.Double loan_max_tenure_amount_from_multiplier;

   private java.lang.Integer loan_max_multiplier;

   private java.lang.Double loan_system_approved_amount;

   private java.lang.Double loan_abb_emi_ratio;

   private java.lang.Double loan_customer_applied_roi;

   private java.lang.Integer loan_max_tenure_allowed;

   public Loan()
   {
   }

   // get emi from loan amount
   public Double EMIfromloanamount(Double loanAmountApplied, Double interestRate, Integer tenure, Integer moratoriumInterestType, Integer moratoriumPeriod, Integer interestPaidDuringMoratoriumPeriod)
   {
      Double tmp_interest_rate = interestRate / 100 / 12;
      Integer tmp_tenure = tenure - moratoriumPeriod;

      if (interestPaidDuringMoratoriumPeriod == 0)
      {
         //simple interest case
         if (moratoriumInterestType == 0)
         {
            Double interestDuringMoratorium = (loanAmountApplied * tmp_interest_rate) * moratoriumPeriod;
            loanAmountApplied += interestDuringMoratorium;
         }
         // compound interest case
         if (moratoriumInterestType == 1)
         {
            for (int i = 1; i <= moratoriumPeriod; i++)
            {
               Double compoundInterestPerPeriodDuringMoratorium = loanAmountApplied * tmp_interest_rate;
               loanAmountApplied += compoundInterestPerPeriodDuringMoratorium;

            }

         }
      }

      Double principal_final_value = loanAmountApplied;
      Double interest_final_value_one_rupee = 0.0;
      for (int i = 1; i <= tmp_tenure; i++)
      {
         interest_final_value_one_rupee *= (1 + tmp_interest_rate);
         interest_final_value_one_rupee++;
      }
      principal_final_value *= Math.pow(1 + tmp_interest_rate, tmp_tenure);

      //NOW CALCULATE EMI BY USING THIS interest_value & principal_value
      // Long EMI = Math.round(principal_final_value / interest_final_value_one_rupee);
      Double emi = principal_final_value / interest_final_value_one_rupee;
      //return EMI;
      //this.emi = emi;
      return emi;
   }

   // emi to loan amount
   public Double loanamountfromemi(Double emi, Double interestRate, Integer tenure, Integer moratoriumInterestType, Integer moratoriumPeriod, Integer interestPaidDuringMoratoriumPeriod)
   {
      Double tmp_interest_rate = interestRate / 100 / 12;
      Integer tmp_tenure = tenure - moratoriumPeriod;
      Double loanamount = emi * ((Math.pow(1 + tmp_interest_rate, tmp_tenure) - 1) / (tmp_interest_rate * (Math.pow(1 + tmp_interest_rate, tmp_tenure))));
      if (interestPaidDuringMoratoriumPeriod == 0)
      {
         if (moratoriumInterestType == 0)
         {
            loanamount = loanamount / (1 + tmp_interest_rate * moratoriumPeriod);

         }
         else
         {
            loanamount = loanamount / Math.pow(1 + tmp_interest_rate, moratoriumPeriod);
         }

      }

      return loanamount;
   }

   public java.lang.Double getLoan_customer_applied_amount()
   {
      return this.loan_customer_applied_amount;
   }

   public void setLoan_customer_applied_amount(
         java.lang.Double loan_customer_applied_amount)
   {
      this.loan_customer_applied_amount = loan_customer_applied_amount;
   }

   public java.lang.Integer getLoan_customer_applied_tenure()
   {
      return this.loan_customer_applied_tenure;
   }

   public void setLoan_customer_applied_tenure(
         java.lang.Integer loan_customer_applied_tenure)
   {
      this.loan_customer_applied_tenure = loan_customer_applied_tenure;
   }

   public java.lang.Double getLoan_system_eligible_loan_amount()
   {
      return this.loan_system_eligible_loan_amount;
   }

   public void setLoan_system_eligible_loan_amount(
         java.lang.Double loan_system_eligible_loan_amount)
   {
      this.loan_system_eligible_loan_amount = loan_system_eligible_loan_amount;
   }

   public java.lang.Double getLoan_system_approved_roi()
   {
      return this.loan_system_approved_roi;
   }

   public void setLoan_system_approved_roi(
         java.lang.Double loan_system_approved_roi)
   {
      this.loan_system_approved_roi = loan_system_approved_roi;
   }

   public java.lang.Integer getLoan_system_approved_tenure()
   {
      return this.loan_system_approved_tenure;
   }

   public void setLoan_system_approved_tenure(
         java.lang.Integer loan_system_approved_tenure)
   {
      this.loan_system_approved_tenure = loan_system_approved_tenure;
   }

   public java.lang.Double getLoan_max_emi_allowed_abb()
   {
      return this.loan_max_emi_allowed_abb;
   }

   public void setLoan_max_emi_allowed_abb(
         java.lang.Double loan_max_emi_allowed_abb)
   {
      this.loan_max_emi_allowed_abb = loan_max_emi_allowed_abb;
   }

   public java.lang.Double getLoan_max_emi_allowed_foir()
   {
      return this.loan_max_emi_allowed_foir;
   }

   public void setLoan_max_emi_allowed_foir(
         java.lang.Double loan_max_emi_allowed_foir)
   {
      this.loan_max_emi_allowed_foir = loan_max_emi_allowed_foir;
   }

   public java.lang.Double getLoan_customer_applied_emi()
   {
      return this.loan_customer_applied_emi;
   }

   public void setLoan_customer_applied_emi(
         Double loanAmountApplied, Double interestRate, Integer tenure, Integer moratoriumInterestType, Integer moratoriumPeriod, Integer interestPaidDuringMoratoriumPeriod)
   {
      Double loancustomerappliedemi = this.EMIfromloanamount(loanAmountApplied, interestRate, tenure, moratoriumInterestType, moratoriumPeriod, interestPaidDuringMoratoriumPeriod);
      this.loan_customer_applied_emi = loancustomerappliedemi;
   }

   public java.util.List<java.lang.Double> getLoan_amount_from_multiplier()
   {
      return this.loan_amount_from_multiplier;
   }

   /*
    public void setLoan_amount_from_multiplier(
    java.util.List<java.lang.Double> loan_amount_from_multiplier)
    {
    this.loan_amount_from_multiplier = loan_amount_from_multiplier;
    }*/

   // method to set list of loan amount from multiplier for different tenure
   public void setLoan_amount_from_multiplier(java.util.List<java.lang.Integer> loan_multiplier, Integer max_tenure, Double combined_net_monthly_income)
   {

      java.util.List<java.lang.Double> loanamountfrommultiplierlist = new ArrayList<Double>();
      Double loanamount = 0.0;
      if (loan_multiplier.size() < max_tenure)
      {
         System.out.println("unable to find multiplier. please provide multiplier values for all possible tenure");
      }
      else
      {
         for (Integer i = 0; i < max_tenure; i++)
         {
            loanamount = combined_net_monthly_income * loan_multiplier.get(i);
            loanamountfrommultiplierlist.add(loanamount);

         }
      }
      this.loan_amount_from_multiplier = loanamountfrommultiplierlist;

   }

   public java.lang.Integer getLoan_multiplier()
   {
      return this.loan_multiplier;
   }

   public void setLoan_multiplier(java.lang.Integer loan_multiplier)
   {
      this.loan_multiplier = loan_multiplier;
   }

   public java.lang.Integer getLoan_multiplier_list()
   {
      return this.loan_multiplier_list;
   }

   public void setLoan_multiplier_list(java.lang.Integer loan_multiplier_list)
   {
      this.loan_multiplier_list = loan_multiplier_list;
   }

   public java.lang.Integer getLoan_moratorium_period()
   {
      return this.loan_moratorium_period;
   }

   public void setLoan_moratorium_period(java.lang.Integer loan_moratorium_period)
   {
      this.loan_moratorium_period = loan_moratorium_period;
   }

   public java.lang.Integer getLoan_moratorium_interest_type()
   {
      return this.loan_moratorium_interest_type;
   }

   public void setLoan_moratorium_interest_type(
         java.lang.Integer loan_moratorium_interest_type)
   {
      this.loan_moratorium_interest_type = loan_moratorium_interest_type;
   }

   public java.lang.Integer getLoan_is_interest_paid_during_moratorium_period()
   {
      return this.loan_is_interest_paid_during_moratorium_period;
   }

   public void setLoan_is_interest_paid_during_moratorium_period(
         java.lang.Integer loan_is_interest_paid_during_moratorium_period)
   {
      this.loan_is_interest_paid_during_moratorium_period = loan_is_interest_paid_during_moratorium_period;
   }

   public java.util.List<java.lang.Double> getLoan_amount_from_servicibility()
   {
      return this.loan_amount_from_servicibility;
   }

   public void setLoan_amount_from_servicibility(
         Double emi, Double interestRate, Integer max_tenure, Integer moratoriumInterestType, Integer moratoriumPeriod, Integer interestPaidDuringMoratoriumPeriod)
   {
      java.util.List<java.lang.Double> loanamountfromservicibilitylist = new ArrayList<Double>();
      Double loanamount = 0.0;
      for (Integer i = 1; i <= max_tenure; i++)
      {
         loanamount = this.loanamountfromemi(emi, interestRate, i * 12, moratoriumInterestType, moratoriumPeriod, interestPaidDuringMoratoriumPeriod);
         loanamountfromservicibilitylist.add(loanamount);

      }
      this.loan_amount_from_servicibility = loanamountfromservicibilitylist;
   }

   public java.util.List<java.lang.Double> getLoan_amount_from_abb()
   {
      return this.loan_amount_from_abb;
   }

   public void setLoan_amount_from_abb(
         Double emi, Double interestRate, Integer max_tenure, Integer moratoriumInterestType, Integer moratoriumPeriod, Integer interestPaidDuringMoratoriumPeriod)
   {
      java.util.List<java.lang.Double> loanamountfromabblist = new ArrayList<Double>();
      Double loanamount = 0.0;
      for (Integer i = 1; i <= max_tenure; i++)
      {
         loanamount = this.loanamountfromemi(emi, interestRate, i * 12, moratoriumInterestType, moratoriumPeriod, interestPaidDuringMoratoriumPeriod);
         loanamountfromabblist.add(loanamount);

      }
      this.loan_amount_from_abb = loanamountfromabblist;
   }

   public java.lang.Double getLoan_amount_from_product_cap()
   {
      return this.loan_amount_from_product_cap;
   }

   public void setLoan_amount_from_product_cap(
         java.lang.Double loan_amount_from_product_cap)
   {
      this.loan_amount_from_product_cap = loan_amount_from_product_cap;
   }

   public java.lang.String getLoan_quotes()
   {
      return this.loan_quotes;
   }

   public void setLoan_quotes(List<Double> multiplier, List<Double> servicibility, Double product_cap, Double interestRate, Integer max_tenure, Integer moratoriumInterestType, Integer moratoriumPeriod, Integer interestPaidDuringMoratoriumPeriod)
   {
      Double minloanamount = null;
      String loan_quote = "";
      Double emi = null;
      for (Integer i = 1; i <= max_tenure; i++)
         {
            minloanamount = Math.min(Math.min(multiplier.get(i-1), servicibility.get(i-1)), product_cap);
            emi = this.EMIfromloanamount(minloanamount, interestRate,  i*12, moratoriumInterestType, moratoriumPeriod, interestPaidDuringMoratoriumPeriod);
            if (minloanamount >= 100000)
            {
               loan_quote = loan_quote + i + "y: INR " + Math.round(minloanamount*10)/10 + " @ " + interestRate + "% =>" + Math.round(emi*10)/10 + "p.m." + "<br>";
            }
         }
      
      if (loan_quote == "")
      {
         loan_quote = "Found no eligible loan quote between min-max loan amounts";
      }

      this.loan_quotes = loan_quote;
   }

   public java.lang.Double getLoan_max_tenure_amount_from_servicibility()
   {
      return this.loan_max_tenure_amount_from_servicibility;
   }

   public void setLoan_max_tenure_amount_from_servicibility(
         java.lang.Double loan_max_tenure_amount_from_servicibility)
   {
      this.loan_max_tenure_amount_from_servicibility = loan_max_tenure_amount_from_servicibility;
   }

   public java.lang.Double getLoan_max_tenure_amount_from_multiplier()
   {
      return this.loan_max_tenure_amount_from_multiplier;
   }

   public void setLoan_max_tenure_amount_from_multiplier(
         java.lang.Double loan_max_tenure_amount_from_multiplier)
   {
      this.loan_max_tenure_amount_from_multiplier = loan_max_tenure_amount_from_multiplier;
   }

   public java.lang.Integer getLoan_max_multiplier()
   {
      return this.loan_max_multiplier;
   }

   public void setLoan_max_multiplier(java.lang.Integer loan_max_multiplier)
   {
      this.loan_max_multiplier = loan_max_multiplier;
   }

   public java.lang.Double getLoan_system_approved_amount()
   {
      return this.loan_system_approved_amount;
   }

   public void setLoan_system_approved_amount(
         java.lang.Double loan_system_approved_amount)
   {
      this.loan_system_approved_amount = loan_system_approved_amount;
   }

   public java.lang.Double getLoan_abb_emi_ratio()
   {
      return this.loan_abb_emi_ratio;
   }

   public void setLoan_abb_emi_ratio(java.lang.Double loan_abb_emi_ratio)
   {
      this.loan_abb_emi_ratio = loan_abb_emi_ratio;
   }

   public java.lang.Double getLoan_customer_applied_roi()
   {
      return this.loan_customer_applied_roi;
   }

   public void setLoan_customer_applied_roi(
         java.lang.Double loan_customer_applied_roi)
   {
      this.loan_customer_applied_roi = loan_customer_applied_roi;
   }

   public java.lang.Integer getLoan_max_tenure_allowed()
   {
      return this.loan_max_tenure_allowed;
   }

   public void setLoan_max_tenure_allowed(java.lang.Integer loan_max_tenure_allowed)
   {
      this.loan_max_tenure_allowed = loan_max_tenure_allowed;
   }

   public Loan(java.lang.Double loan_customer_applied_amount,
         java.lang.Integer loan_customer_applied_tenure,
         java.lang.Double loan_system_eligible_loan_amount,
         java.lang.Double loan_system_approved_roi,
         java.lang.Integer loan_system_approved_tenure,
         java.lang.Double loan_max_emi_allowed_abb,
         java.lang.Double loan_max_emi_allowed_foir,
         java.lang.Double loan_customer_applied_emi,
         java.util.List<java.lang.Double> loan_amount_from_multiplier,
         java.lang.Integer loan_multiplier,
         java.lang.Integer loan_multiplier_list,
         java.lang.Integer loan_moratorium_period,
         java.lang.Integer loan_moratorium_interest_type,
         java.lang.Integer loan_is_interest_paid_during_moratorium_period,
         java.util.List<java.lang.Double> loan_amount_from_servicibility,
         java.util.List<java.lang.Double> loan_amount_from_abb,
         java.lang.Double loan_amount_from_product_cap,
         java.lang.String loan_quotes,
         java.lang.Double loan_max_tenure_amount_from_servicibility,
         java.lang.Double loan_max_tenure_amount_from_multiplier,
         java.lang.Integer loan_max_multiplier,
         java.lang.Double loan_system_approved_amount,
         java.lang.Double loan_abb_emi_ratio,
         java.lang.Double loan_customer_applied_roi,
         java.lang.Integer loan_max_tenure_allowed)
   {
      this.loan_customer_applied_amount = loan_customer_applied_amount;
      this.loan_customer_applied_tenure = loan_customer_applied_tenure;
      this.loan_system_eligible_loan_amount = loan_system_eligible_loan_amount;
      this.loan_system_approved_roi = loan_system_approved_roi;
      this.loan_system_approved_tenure = loan_system_approved_tenure;
      this.loan_max_emi_allowed_abb = loan_max_emi_allowed_abb;
      this.loan_max_emi_allowed_foir = loan_max_emi_allowed_foir;
      this.loan_customer_applied_emi = loan_customer_applied_emi;
      this.loan_amount_from_multiplier = loan_amount_from_multiplier;
      this.loan_multiplier = loan_multiplier;
      this.loan_multiplier_list = loan_multiplier_list;
      this.loan_moratorium_period = loan_moratorium_period;
      this.loan_moratorium_interest_type = loan_moratorium_interest_type;
      this.loan_is_interest_paid_during_moratorium_period = loan_is_interest_paid_during_moratorium_period;
      this.loan_amount_from_servicibility = loan_amount_from_servicibility;
      this.loan_amount_from_abb = loan_amount_from_abb;
      this.loan_amount_from_product_cap = loan_amount_from_product_cap;
      this.loan_quotes = loan_quotes;
      this.loan_max_tenure_amount_from_servicibility = loan_max_tenure_amount_from_servicibility;
      this.loan_max_tenure_amount_from_multiplier = loan_max_tenure_amount_from_multiplier;
      this.loan_max_multiplier = loan_max_multiplier;
      this.loan_system_approved_amount = loan_system_approved_amount;
      this.loan_abb_emi_ratio = loan_abb_emi_ratio;
      this.loan_customer_applied_roi = loan_customer_applied_roi;
      this.loan_max_tenure_allowed = loan_max_tenure_allowed;
   }

}