package ValidIpAddress;

public class ValidIpAddress {
    public static void main(String[] args) {

    }


    public String validIPAddress(String IP) {
        if (IP.chars().filter(x -> (x == '.')).count() == 3) {
            return validIpv4(IP);
        } else if (IP.chars().filter(x -> (x == ':')).count() == 7) {
            return validIpv6(IP);
        } else return "Neither";
    }

    public String validIpv4(String str) {
        String[] ips = str.split("\\.");
        if (ips.length != 4) return "Neither";
        for (String ip : ips) {
            if (ip.length() == 0 || ip.length() > 3) {
                return "Neither";
            }
            if (ip.charAt(0) == '0' && ip.length() != 1) {
                return "Neither";
            }
            for (char ch : ip.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            if (Integer.parseInt(ip) < 0 || Integer.parseInt(ip) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validIpv6(String str) {
        String[] ips = str.split(":");
        if (ips.length != 8) return "Neither";
        for (String ip : ips) {
            if (ip.length() == 0 || ip.length() > 4) {
                return "Neither";
            }
            for (char ch : ip.toCharArray()) {
                if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
