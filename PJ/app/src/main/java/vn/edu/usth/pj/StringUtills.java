package vn.edu.usth.pj;

public final class StringUtills {
    public static final String fromHtml(String link){
        link = link.replace("&#8206;", "\u200E")
                .replace("&#8207;", "\u200F")
                .replace("&amp;", "&");

        link = link.replace("<img ", "<figure ").replace("</img>", "</figure>");

        return link;
    }
}
