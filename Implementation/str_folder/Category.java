import java.util.stream.Stream;

// Categories Enum
public enum Category {
    GROCERIES (1, "Food & Groceries"),
    PERSONAL (2, "Personal Care"),
    UTILITIES (3, "Utilies"),
    ENTERTAINMENT (4, "Entertainment"),
    EMERGENCY (5, "Emergency Funds"),
    OTHER (6, "Other");
	
	private final int id;
	private final String title;
	Category(int _id, String _title) {
		this.id = _id;
		this.title = _title;
	}
	public int id() { return id; }
	public String title() { return title; }
	public static Stream<Category> stream() {
		return Stream.of(Category.values());
	}
}
