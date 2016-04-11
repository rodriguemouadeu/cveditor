package com.rodriguemouadeu.ui.steps;

import java.util.Random;

import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ThirdStep implements WizardStep {

	public String getCaption() {
		return "Third Step";
	}

	public Component getContent() {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
		
		TabSheet  sample = new TabSheet();
        sample.setHeight(100.0f, Unit.PERCENTAGE);
        sample.addStyleName(ValoTheme.TABSHEET_FRAMED);
        sample.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
 
        for (int i = 1; i < 8; i++) {
            final VerticalLayout layout = new VerticalLayout(new Label(getLoremIpsum()));
            layout.setMargin(true);
            sample.addTab(layout, "Tab " + i);
        }
		verticalLayout.addComponent(sample);
		
		return verticalLayout;
	}

	private String getLoremIpsum() {
		String[] lines = {
				"Ras bibendum egestas nulla. Phasellus pulvinar ullamcorper odio. Etiam ipsum. Proin tincidunt. Aliquam aliquet. ",
				"Etiam purus odio, commodo sed, feugiat volutpat, scelerisque molestie, velit. Aenean sed sem sit amet libero sodales ultrices.",
				"Donec dictum, arcu sed iaculis porttitor, est mauris pulvinar purus, sit amet porta purus neque in risus. Mauris libero. Maecenas rhoncus.",
				"Morbi quis nisl.", 
				"Vestibulum laoreet tortor eu elit.", 
				"Cras euismod nulla eu sapien. Sed imperdiet. Maecenas vel sapien.", 
				"Nulla at purus eu diam auctor lobortis. Donec pede eros, lacinia tincidunt, tempus eu, molestie nec, velit. ",
				"Nullam ipsum odio, euismod non, aliquet nec, consequat ac, felis. Duis fermentum mauris sed justo. Suspendisse potenti. ",
				"Praesent at libero sit amet ipsum imperdiet fermentum. Aliquam enim nisl, dictum id, lacinia sit amet, elementum posuere, ipsum. ",
				"Integer luctus dictum libero. Pellentesque sed pede sed nisl bibendum porttitor. Phasellus tempor interdum nisi. Mauris nec magna.",
				"Phasellus massa pede, vehicula sed, ornare at, ullamcorper ut, nisl. Sed turpis nisl, hendrerit sit amet, consequat id, auctor nec, arcu. ",
				"Quisque fringilla tincidunt massa. In eleifend, nulla sed mollis vestibulum, mauris orci facilisis ante, id pharetra dolor ipsum vitae sem.",
				"Integer dictum.",
				"Nunc ut odio. Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 
				"Donec mauris tellus, dapibus vel, hendrerit vel, sollicitudin ut, ligula.",
				"Ut justo metus, accumsan placerat, ultrices sit amet, congue at, nulla.",
				"Integer in quam. Cras sollicitudin mattis magna. Vestibulum neque eros, egestas ut, tincidunt vel, ullamcorper non, ligula.", 
				"Vivamus eu lacus. Donec rhoncus metus et odio. Donec est. Nulla facilisi. Suspendisse potenti. Etiam tempor pede nec ante. ",
				"Vestibulum adipiscing velit vel neque.", 
				"Quisque ornare erat rhoncus lectus.", "Donec vitae ante at enim mollis egestas. Mauris convallis. ", 
				"Fusce convallis, nisl eu sagittis suscipit, risus ligula aliquam libero, in imperdiet neque mi non risus. ", 
				"Aenean dictum ultricies risus. Praesent ut ligula vitae purus ornare auctor. ", 
				"Cras tellus mauris, adipiscing ac, dignissim auctor, faucibus in, sem. ", 
				"Cras mauris libero, pharetra sit amet, lacinia eu, vehicula eleifend, sapien.", 
				" Donec ac tellus. Sed eros dui, vulputate vel, auctor pharetra, tincidunt at, ipsum. Duis at dolor ac leo condimentum pulvinar. ", 
				"Donec molestie, dolor et fringilla elementum, nibh nibh iaculis orci, eu elementum odio turpis et odio. ", 
				"Phasellus fermentum, justo id placerat egestas, arcu nunc molestie ante, non imperdiet ligula lectus sed erat. ", 
				"Quisque sed ligula. Sed ac nulla. Nullam massa.", 
				"Sed a purus. Mauris non nibh blandit neque cursus scelerisque. Quisque ultrices sem nec dolor. ", 
				"Donec non diam ut dui consequat venenatis. Nullam risus massa, egestas in, facilisis tristique, molestie sed, mi. ", 
				"Duis euismod turpis sit amet quam. Vestibulum ornare felis eget dolor. Phasellus ac urna vel sapien lacinia adipiscing. ", 
				"Donec egestas felis id mi. Sed erat. Vestibulum porta vulputate neque. ", 
				"Maecenas scelerisque, sem id sodales pretium, sem mauris rhoncus magna, at scelerisque tortor mauris nec dui. Nullam blandit rhoncus velit. ", 
				"Nam accumsan, enim id vestibulum feugiat, lorem nibh placerat urna, eget laoreet diam tortor at lorem. Suspendisse imperdiet consectetur dolor. ", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ut massa eget erat dapibus sollicitudin. ", 
				"Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque a augue. Praesent non elit. ", 
				"Duis sapien dolor, cursus eget, pulvinar eget, eleifend a, est. Integer in nunc. Vivamus consequat ipsum id sapien. ", 
				"Duis eu elit vel libero posuere luctus. Aliquam ac turpis. Aenean vitae justo in sem iaculis pulvinar. ", 
				"Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam sit amet mi." 
		};
		
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < lines.length; i++){
			result.append(lines[new Random().nextInt(lines.length)]);
		}
		return result.toString();
	}

	public boolean onAdvance() {
		return false;
	}

	public boolean onBack() {
		return true;
	}
	
}
