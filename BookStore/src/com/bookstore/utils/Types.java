package com.bookstore.utils;


public class Types {

	public enum CreateType {
		BOOK,AUTHOR,CATEGORY,UNKNOWN;
		public static CreateType getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return UNKNOWN;
			}
		};

	}

	public enum ActionType {
		Save, Delete, Update, Reassign, Accept, Reject, Unknown, Search;

		public static ActionType getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return Unknown;
			}
		};

	}

	public enum SearchType {

		AllEmployees,Unknown;
		public static SearchType getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return Unknown;
			}
		};

	}

	public enum ReceiveType {

		COUNTLIST,Unknown;

		public static ReceiveType getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return Unknown;
			}
		};

	}

	public enum DataType {

		Int, Unknown;

		public static DataType getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return Unknown;
			}
		};

	}

	public enum TaskStatus {

		UNKNOWN, OPEN, CLOSED, PENDING, REJECTED, ACCEPTED, COMPLETED;
		public static TaskStatus getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return UNKNOWN;
			}
		};
	}

	public enum FeasibilityStatus {

		UNKNOWN, FEASIBLE, FEASIBLE_PENDING, NOT_FEASIBLE;
		public static FeasibilityStatus getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return UNKNOWN;
			}
		};
	}

	public enum TemplateType {

		FORGOT_PASSWORD("ForgotPassword"), HOT_PROSPECT_TO_NE_AI(
				"HotProspectToNeAi"), REASSIGNING_NE_TO_NE_AI(
				"ReassigningNeToNeAi"), FEASIBILITY_DONE_SC_SR(
				"FeasibilityDoneToSCSR"), FEASIBILITY_DONE_AI(
				"FeasibilityDoneToAI"), NOT_FEASIBLE_TO_AI_SC_SR(
				"NotFeasibleToAiScSr"), NOT_FEASIBLE_TO_CUSTOMER(
				"NotFeasibleToCustomer"), NEW_CX("NewCx"), DOC_ACCEPTED(
				"DocAccepted"), ESCALATION("Escalation"), FEASIBILITY_STATUS(
				"FeasibilityStatus");
		String type;

		TemplateType(String type) {
			this.type = type;
		}

		public String getValue() {
			return this.type;
		}
	}

	public enum NotificationType {
		CUSTOMER_SMS_NOTIFICATION, CUSTOMER_EMAIL_NOTIFICATION, CUSTOMER_BOTH, EMPLOYEE_SMS_NOTIFICATION, EMPLOYEE_EMAIL_NOTIFICATION, EMPLOYEE_BOTH;
		public static NotificationType getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return null;
			}
		};
	}

	public enum CallType {
		UNKNOWN, HOT, LEAD, MEADIUM, COLD, REJECTED;
	}

	public enum FeasibilityOrWOAgingConstants {

		FEASIBILITY_OR_WO_AGING_0_2(2), FEASIBILITY_OR_WO_AGING_2_4(4), FEASIBILITY_OR_WO_AGING_4_8(
				8), FEASIBILITY_OR_WO_AGING_8_16(16), FEASIBILITY_OR_WO_AGING_16_24(
				24), FEASIBILITY_OR_WO_AGING_24_48(48), FEASIBILITY_OR_WO_AGING_48_PLUS(
				48), FEASIBILITY_OR_WO_AGING_0_2HRS("0-2"), FEASIBILITY_OR_WO_AGING_2_4HRS(
				"2-4"), FEASIBILITY_OR_WO_AGING_4_8HRS("4-8"), FEASIBILITY_OR_WO_AGING_8_16HRS(
				"8-16"), FEASIBILITY_OR_WO_AGING_16_24HRS("16-24"), FEASIBILITY_OR_WO_AGING_24_48HRS(
				"24-48"), FEASIBILITY_OR_WO_AGING_48_PLUSHRS("48-plus");

		private int hoursValue;
		private String hoursStr;

		FeasibilityOrWOAgingConstants(int hoursValue) {
			this.hoursValue = hoursValue;
		}

		FeasibilityOrWOAgingConstants(String hoursStr) {
			this.hoursStr = hoursStr;
		}

		public int getHoursValue() {
			return hoursValue;
		}

		public String getHoursStr() {
			return hoursStr;
		}

	}

	public enum RoleType {

		ADMIN(1), AREA_INCHARGE(2), NETWORK_ENGINEER(3), CFE(4), NOC(5), CSR(6), SALES_REPRESENTATIVE(
				7), ACCOUNTS(8), SALES_COORDINATOR(9);

		private int roleId;

		RoleType(int roleId) {
			this.roleId = roleId;
		}

		public int getRoleId() {
			return roleId;

		}
	}
}