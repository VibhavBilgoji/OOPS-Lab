import java.util.*;

public class Navigate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Browser Navigation System =====");

        // Get previous pages
        System.out.print("\nEnter number of pages in previous history: ");
        int prevCount = sc.nextInt();
        sc.nextLine();

        Page[] prevPages = new Page[prevCount];
        System.out.println("\nEnter previous pages (one by one):");
        for (int i = 0; i < prevCount; i++) {
            System.out.print("\nPage " + (i + 1) + " URL: ");
            String url = sc.nextLine();
            System.out.print("Page " + (i + 1) + " Title: ");
            String title = sc.nextLine();
            prevPages[i] = new Page(url, title);
        }

        // Get current page
        System.out.print("\nEnter current page URL: ");
        String currUrl = sc.nextLine();
        System.out.print("Enter current page Title: ");
        String currTitle = sc.nextLine();
        Page currPage = new Page(currUrl, currTitle);

        // Get next pages
        System.out.print("\nEnter number of pages in next history: ");
        int nextCount = sc.nextInt();
        sc.nextLine(); // consume newline

        Page[] nextPages = new Page[nextCount];
        System.out.println("\nEnter next pages (one by one):");
        for (int i = 0; i < nextCount; i++) {
            System.out.print("\nPage " + (i + 1) + " URL: ");
            String url = sc.nextLine();
            System.out.print("Page " + (i + 1) + " Title: ");
            String title = sc.nextLine();
            nextPages[i] = new Page(url, title);
        }

        NavigationSystem browser = new NavigationSystem(prevPages, nextPages, currPage);

        System.out.println("\n===== Navigation Menu =====");
        System.out.println("Current Page: " + currPage);
        menuDriven(sc, browser);

        sc.close();
    }

    private static void menuDriven(Scanner sc, NavigationSystem browser) {
        while (true) {
            System.out.println("\n1. Back");
            System.out.println("2. Forward");
            System.out.println("3. Visit New Page");
            System.out.println("4. Show Current Page");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nGoing back...");
                    browser.back();
                    break;
                case 2:
                    System.out.println("\nGoing forward...");
                    browser.forward();
                    break;
                case 3:
                    System.out.print("\nEnter URL: ");
                    String url = sc.nextLine();
                    System.out.print("Enter Page Title: ");
                    String title = sc.nextLine();

                    if (!url.isEmpty() && !title.isEmpty()) {
                        browser.visit(new Page(url, title));
                    } else {
                        System.out.println("Invalid input. URL and title cannot be empty.");
                    }
                    break;
                case 4:
                    browser.showCurrentPage();
                    break;
                case 5:
                    System.out.println("\nExiting browser...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
            }
        }
    }
}

class Page {
    private String url, title;

    public Page() {url = title = "";}
    public Page(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getURL() { return url; }
    public void setURL(String url) { this.url = url; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        return "Page{" + "url='" + url + '\'' + ", title='" + title + '\'' + '}';
    }
}

class NavigationSystem {
    private final Stack<Page> prev, next;
    private Page currPage;

    public NavigationSystem() {
        prev = new Stack<>();
        next = new Stack<>();
        currPage = new Page();
    }

    public NavigationSystem(Page[] prevPages, Page[] nextPages, Page curr) {
        prev = new Stack<>();
        next = new Stack<>();
        for (Page p : prevPages) prev.push(p);
        for (Page p : nextPages) next.push(p);
        currPage = curr;
    }

    public void visit(Page page) {
        System.out.println("Page URL: " + page.getURL());
        System.out.println("Page Title: " + page.getTitle() + "\n");

        if (!currPage.getURL().isEmpty()) {
            if (prev.empty() || !prev.peek().getURL().equals(currPage.getURL())) {
                prev.push(currPage);
            }
        }
        next.clear();
        currPage = page;
    }

    public void back() {
        if (prev.empty()) {
            System.out.println("No Previous Page Found.\n");
            return;
        }

        if (!currPage.getURL().isEmpty()) {next.push(currPage);}

        currPage = prev.pop();
        System.out.println("Page URL: " + currPage.getURL());
        System.out.println("Page Title: " + currPage.getTitle() + "\n");
    }

    public void forward() {
        if (next.empty()) {
            System.out.println("No Next page found.\n");
            return;
        }

        if (!currPage.getURL().isEmpty()) {prev.push(currPage);}

        currPage = next.pop();
        System.out.println("Page URL: " + currPage.getURL());
        System.out.println("Page Title: " + currPage.getTitle() + "\n");
    }

    public String getCurrentPage() {return currPage.toString();}

    public void showCurrentPage() {
        System.out.println("\nCurrent Page:");
        System.out.println("URL: " + currPage.getURL());
        System.out.println("Title: " + currPage.getTitle());
    }

    @Override
    public String toString() {
        return "NavigationSystem{" + "prev=" + prev + ", next=" + next + ", currPage=" + currPage + '}';
    }
}
