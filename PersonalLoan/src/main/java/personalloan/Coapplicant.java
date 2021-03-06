package personalloan;

import java.util.*;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Coapplicant implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   private Double coapplicant_age;

   private Integer coapplicant_cibil_score_v2;

   private java.lang.String coapplicant_dob;

   private java.lang.Double coapplicant_income;

   private Double coapplicant_cibil_total_obligations_considered;

   private Double coapplicant_cibil_total_obligations;

   public Coapplicant()
   {
   }

   public java.lang.String getCoapplicant_dob()
   {
      return this.coapplicant_dob;
   }

   public void setCoapplicant_dob(java.lang.String coapplicant_dob)
   {
      this.coapplicant_dob = coapplicant_dob;
   }

   public java.lang.Double getCoapplicant_age()
   {
      return this.coapplicant_age;
   }

   public void setCoapplicant_age(java.lang.Double coapplicant_age)
   {
      this.coapplicant_age = coapplicant_age;
   }

   public java.lang.Double getCoapplicant_income()
   {
      return this.coapplicant_income;
   }

   public void setCoapplicant_income(java.lang.Double coapplicant_income)
   {
      this.coapplicant_income = coapplicant_income;
   }

   public java.lang.Double getCoapplicant_cibil_total_obligations_considered()
   {
      return this.coapplicant_cibil_total_obligations_considered;
   }

   public void setCoapplicant_cibil_total_obligations_considered(
         java.lang.Double coapplicant_cibil_total_obligations_considered)
   {
      this.coapplicant_cibil_total_obligations_considered = coapplicant_cibil_total_obligations_considered;
   }

   public java.lang.Double getCoapplicant_cibil_total_obligations()
   {
      return this.coapplicant_cibil_total_obligations;
   }

   public void setCoapplicant_cibil_total_obligations(
         java.lang.Double coapplicant_cibil_total_obligations)
   {
      this.coapplicant_cibil_total_obligations = coapplicant_cibil_total_obligations;
   }

   public java.lang.Integer getCoapplicant_cibil_score_v2()
   {
      return this.coapplicant_cibil_score_v2;
   }

   public void setCoapplicant_cibil_score_v2(
         java.lang.Integer coapplicant_cibil_score_v2)
   {
      this.coapplicant_cibil_score_v2 = coapplicant_cibil_score_v2;
   }

   public Coapplicant(java.lang.Double coapplicant_age,
         java.lang.Integer coapplicant_cibil_score_v2,
         java.lang.String coapplicant_dob, java.lang.Double coapplicant_income,
         java.lang.Double coapplicant_cibil_total_obligations_considered,
         java.lang.Double coapplicant_cibil_total_obligations)
   {
      this.coapplicant_age = coapplicant_age;
      this.coapplicant_cibil_score_v2 = coapplicant_cibil_score_v2;
      this.coapplicant_dob = coapplicant_dob;
      this.coapplicant_income = coapplicant_income;
      this.coapplicant_cibil_total_obligations_considered = coapplicant_cibil_total_obligations_considered;
      this.coapplicant_cibil_total_obligations = coapplicant_cibil_total_obligations;
   }

}
