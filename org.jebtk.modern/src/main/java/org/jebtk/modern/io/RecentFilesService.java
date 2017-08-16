/**
 * Copyright (C) 2016, Antony Holmes
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. Neither the name of copyright holder nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.jebtk.modern.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;

import org.jebtk.core.AppService;
import org.jebtk.core.collections.ArrayListCreator;
import org.jebtk.core.collections.DefaultTreeMap;
import org.jebtk.core.event.ChangeListeners;
import org.jebtk.core.io.FileIsNotADirException;
import org.jebtk.core.io.FileUtils;
import org.jebtk.core.io.PathUtils;
import org.jebtk.core.json.Json;
import org.jebtk.core.json.JsonArray;
import org.jebtk.core.json.JsonObject;
import org.jebtk.core.json.JsonParser;
import org.jebtk.core.json.JsonRepresentation;
import org.jebtk.core.settings.SettingsService;
import org.jebtk.core.xml.XmlRepresentation;
import org.jebtk.core.xml.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


// TODO: Auto-generated Javadoc
/**
 * Maintains a list of recently opened files as well as the
 * currently directory, allowing the lists to be shared
 * amongst multiple windows/apps in the same process.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class RecentFilesService extends ChangeListeners implements XmlRepresentation, JsonRepresentation, Iterable<Path> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The Class RecentFilesServiceLoader.
	 */
	private static class RecentFilesServiceLoader {
		
		/** The Constant INSTANCE. */
		private static final RecentFilesService INSTANCE = new RecentFilesService();
	}

	/**
	 * Gets the single instance of SettingsService.
	 *
	 * @return single instance of SettingsService
	 */
	public static RecentFilesService getInstance() {
		return RecentFilesServiceLoader.INSTANCE;
	}

	// the format to store and read back dates in, when loading the recent
	/**
	 * The constant STORAGE_DATE_FORMAT.
	 */
	// files list
	public static final String STORAGE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * The log.
	 */
	private final Logger LOG = 
			LoggerFactory.getLogger(RecentFilesService.class);

	/**
	 * The member pwd.
	 */
	private Path mPwd = PathUtils.getPwd();

	/**
	 * The member loaded.
	 */
	private boolean mLoaded = false;

	/**
	 * The constant MAX_FILES.
	 */
	public static final int MAX_FILES = 
			SettingsService.getInstance().getAsInt("ui.recent-files.max-files");

	/**
	 * The constant DEFAULT_XML_FILE.
	 */
	public static final Path DEFAULT_XML_FILE = 
			PathUtils.getPath("recent.files.xml");

	/** The Constant DEFAULT_JSON_FILE. */
	public static final Path DEFAULT_JSON_FILE = 
			PathUtils.getPath("recent.files.json");

	/** The Constant USER_JSON_FILE. */
	public static final Path USER_JSON_FILE = 
			AppService.getInstance().getAppDir().resolve("recent.files.json");

	/** The m file type map. */
	private Map<String, List<Path>> mFileTypeMap =
			DefaultTreeMap.create(new ArrayListCreator<Path>());

	/** The m files. */
	private List<Path> mFiles = new ArrayList<Path>();

	/** The m date map. */
	private Map<Path, Date> mDateMap = new HashMap<Path, Date>();


	/**
	 * The Class RecentFilesXmlHandler.
	 */
	public class RecentFilesXmlHandler extends DefaultHandler {
		
		/** The m df. */
		private SimpleDateFormat mDf;

		/**
		 * Instantiates a new recent files xml handler.
		 */
		public RecentFilesXmlHandler() {
			mDf = new SimpleDateFormat(RecentFilesService.STORAGE_DATE_FORMAT);
		}

		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public final void startElement(String uri,
				String localName,
				String qName,
				Attributes attributes) throws SAXException {

			if (qName.equals("files")) {
				System.err.println("xml pwd " + attributes.getValue("pwd"));
				
				mPwd = PathUtils.getPath(attributes.getValue("pwd"));
			} else if (qName.equals("file")) {
				Path file = PathUtils.getPath(attributes.getValue("name"));

				if (FileUtils.exists(file)) {
					if (attributes.getValue("date") != null) {
						try {
							Date date = mDf.parse(attributes.getValue("date"));

							mDateMap.put(file, date);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}

					mFiles.add(file);
				}
			} else {

			}
		}

		/**
		 * Gets the pwd.
		 *
		 * @return the pwd
		 */
		public Path pwd() {
			return mPwd;
		}
	}

	/**
	 * Instantiates a new recent files service.
	 */
	public RecentFilesService() {
		init();
	}

	/**
	 * Instantiates a new recent files service.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SAXException the SAX exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws FileIsNotADirException the file is not A dir exception
	 */
	public RecentFilesService(Path file) throws IOException, SAXException, ParserConfigurationException, FileIsNotADirException {
		init();

		loadJson(file);
	}

	/**
	 * Inits the.
	 */
	private void init() {
		mPwd = FileUtils.home(); //PathUtils.getPath("");
	}

	/**
	 * Load.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SAXException the SAX exception
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public void loadXml() throws IOException, SAXException, ParserConfigurationException {
		loadXml(DEFAULT_XML_FILE);
	}

	/**
	 * Load xml.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SAXException the SAX exception
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public synchronized void loadXml(Path file) throws IOException, SAXException, ParserConfigurationException {
		if (FileUtils.exists(file)) {
			LOG.info("Parsing recent files from {}...", file);

			SAXParserFactory factory = SAXParserFactory.newInstance();

			SAXParser saxParser = null;

			saxParser = factory.newSAXParser();

			RecentFilesXmlHandler handler = new RecentFilesXmlHandler();

			saxParser.parse(file.toFile(), handler);
		}
	}

	/**
	 * Load.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SAXException the SAX exception
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public void loadJson() throws IOException, SAXException, ParserConfigurationException {
		loadJson(DEFAULT_JSON_FILE);
		
		// Load the file from the user directory as this is where we want to
		// store things
		loadJson(USER_JSON_FILE);
	}

	/**
	 * Load xml.
	 *
	 * @param jsonFile the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SAXException the SAX exception
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public synchronized void loadJson(Path jsonFile) throws IOException, SAXException, ParserConfigurationException {
		// If the file does not exist, create a default instance
		if (Files.exists(jsonFile)) {
			//createNewFileList();

			LOG.info("Parsing recent files from {}...", jsonFile);

			Json json = new JsonParser().parse(jsonFile);

			Json filesJson = json.get("files");

			List<Path> files = new ArrayList<Path>();

			SimpleDateFormat df = new SimpleDateFormat(STORAGE_DATE_FORMAT);

			for (int i = 0; i < filesJson.size(); ++i) {
				Json fileJson = filesJson.get(i);

				//System.err.println("file json " + fileJson.toString());

				Path file = PathUtils.getPath(fileJson.get("file").getAsString());

				if (FileUtils.exists(file)) {
					Date date = null;
					
					try {
						date = df.parse(fileJson.get("date").getAsString());
					} catch (ParseException e) {
						e.printStackTrace();
					}

					files.add(file);

					mDateMap.put(file, date);
				}
			}

			mFiles.addAll(files);
			setPwd(PathUtils.getPath(json.get("pwd").getAsString()));
		}
	}

	/* (non-Javadoc)
	 * @see java.util.ArrayList#iterator()
	 */
	@Override
	public Iterator<Path> iterator() {
		// Attempt to auto load files if they
		// have not already been done so

		try {
			autoLoad();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return mFiles.iterator();
	}

	/**
	 * Auto load.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SAXException the SAX exception
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	private void autoLoad() throws IOException, SAXException, ParserConfigurationException {
		if (!mLoaded) {
			mLoaded = true;

			LOG.info("Auto load recent files.");

			loadXml();
			
			loadJson();
		}
	}

	/**
	 * Adds the.
	 *
	 * @param file the file
	 * @return true, if successful
	 */
	public synchronized boolean add(Path file) {
		return addFile(file);
	}

	/**
	 * Adds the file.
	 *
	 * @param file the file
	 * @return true, if successful
	 */
	public synchronized boolean addFile(Path file) {
		file = file.toAbsolutePath();
		
		if (FileUtils.exists(file)) {
			setPwd(file.getParent());

			//List<Path> current = new ArrayList<Path>(mFiles);

			// Remove from its old position
			mFiles.remove(file);
			mFileTypeMap.get(PathUtils.getFileExt(file)).remove(file);

			// Add file to head of list
			mFiles.add(0, file);

			mFileTypeMap.get(PathUtils.getFileExt(file)).add(file);
			mDateMap.put(file, Calendar.getInstance().getTime());

			try {
				write();
			} catch (IOException | TransformerException | ParserConfigurationException e) {
				e.printStackTrace();
			}

			fireChanged();

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds the file.
	 *
	 * @param file the file
	 * @param date the date
	 */
	public void addFile(Path file, Date date) {
		file = file.toAbsolutePath();
		
		if (addFile(file)) {
			mDateMap.put(file, date);
		}
	}

	/**
	 * Return only files with a particular extension.
	 *
	 * @param exts the exts
	 * @return the files by ext
	 */
	public List<Path> getFilesByExt(String... exts) {
		List<Path> ret = new ArrayList<Path>();

		for (String ext : exts) {
			ret.addAll(mFileTypeMap.get(ext));
		}

		return ret;
	}

	/**
	 * Write.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public synchronized void write() throws IOException, TransformerException, ParserConfigurationException {
		writeJson();
		//writeXml();
	}

	/**
	 * Write xml.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public synchronized void writeXml() throws IOException, TransformerException, ParserConfigurationException {
		writeXml(DEFAULT_XML_FILE);
	}

	/**
	 * Write xml.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public synchronized void writeXml(Path file) throws IOException, TransformerException, ParserConfigurationException {

		LOG.info("Writing recent files to {}...", file);

		Document doc = XmlUtils.createDoc();

		doc.appendChild(toXml(doc));

		//XmlDocument.writeXml(doc, file);

		XmlUtils.writeXml(doc, file);
	}

	/**
	 * Write json.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public synchronized void writeJson() throws IOException {
		writeJson(USER_JSON_FILE);
	}

	/**
	 * Write xml.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public synchronized void writeJson(Path file) throws IOException {
		LOG.info("Writing recent files to {}...", file);

		Json.prettyWrite(toJson(), file);
	}

	/**
	 * Gets the pwd.
	 *
	 * @return the pwd
	 */
	public Path getPwd() {
		try {
			autoLoad();
		} catch (IOException | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}

		System.err.println("pwd " + mPwd);

		return mPwd;
	}

	/**
	 * Set the present working directory.
	 *
	 * @param pwd the new pwd
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SAXException the SAX exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws TransformerException the transformer exception
	 */
	public synchronized void setPwd(File pwd) throws IOException, SAXException, ParserConfigurationException, TransformerException {
		setPwd(pwd.toPath());
	}

	/**
	 * Sets the pwd.
	 *
	 * @param pwd the new pwd
	 */
	public synchronized void setPwd(Path pwd) {
		try {
			autoLoad();
		} catch (IOException | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}

		mPwd = pwd.toAbsolutePath();

		System.err.println("pwd " + mPwd);

		
		
		try {
			write();
		} catch (IOException | TransformerException | ParserConfigurationException e) {
			e.printStackTrace();
		}

		fireChanged();
	}

	/* (non-Javadoc)
	 * @see org.abh.lib.xml.XmlRepresentation#toXml()
	 */
	@Override
	public Element toXml(Document doc) {
		SimpleDateFormat df = new SimpleDateFormat(STORAGE_DATE_FORMAT);

		Element filesElement = doc.createElement("files");

		filesElement.setAttribute("pwd", mPwd.toAbsolutePath().toString());

		// We write out no more than max files
		int n = Math.min(mFiles.size(), MAX_FILES);

		for (int i = 0; i < n; ++i) {
			Path f = mFiles.get(i);

			Element fileElement = doc.createElement("file");
			fileElement.setAttribute("name", PathUtils.toString(f));
			fileElement.setAttribute("date", df.format(mDateMap.get(f)));
			filesElement.appendChild(fileElement);
		}

		return filesElement;
	}

	/* (non-Javadoc)
	 * @see org.abh.common.json.JsonRepresentation#toJson()
	 */
	@Override
	public Json toJson() {
		Json o = new JsonObject();

		o.add("pwd", mPwd.toAbsolutePath());

		Json filesJ = new JsonArray();

		SimpleDateFormat df = new SimpleDateFormat(STORAGE_DATE_FORMAT);

		for (Path f : this) {
			Json fileJ = new JsonObject();

			fileJ.add("file", f);
			fileJ.add("date", df.format(mDateMap.get(f)));

			filesJ.add(fileJ);
		}

		o.add("files", filesJ);

		return o;
	}

	/**
	 * Gets the date.
	 *
	 * @param file the file
	 * @return the date
	 */
	public Date getDate(Path file) {
		return mDateMap.get(file);
	}
}
