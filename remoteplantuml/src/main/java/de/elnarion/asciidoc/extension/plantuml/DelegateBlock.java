package de.elnarion.asciidoc.extension.plantuml;

import java.util.List;
import java.util.Map;

import org.asciidoctor.ast.AbstractBlock;
import org.asciidoctor.ast.AbstractNode;
import org.asciidoctor.ast.Block;
import org.asciidoctor.ast.DocumentRuby;

/**
 * This class is just a simple wrapper around a asciidoc block instance which
 * adds a content_model method. This is necessary because sometimes asciidoctor
 * in jruby needs a content_model method but the original block instance in java
 * does not provide one.
 */
public class DelegateBlock implements Block {

	/** The abstract block. */
	private Block abstractBlock;

	/** The content model. */
	private Object contentModel;

	/**
	 * Instantiates a new delegate block.
	 *
	 * @param paramAbstractBloc the param abstract bloc
	 * @param paramContentModel the param content model
	 */
	public DelegateBlock(Block paramAbstractBloc, Object paramContentModel) {
		this.abstractBlock = paramAbstractBloc;
		this.contentModel = paramContentModel;
	}

	/**
	 * Gets the orig block.
	 *
	 * @return AbstractBlock - the orig block
	 */
	public AbstractBlock getOrigBlock() {
		return abstractBlock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return abstractBlock.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return abstractBlock.equals(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return abstractBlock.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#blocks()
	 */
	@Override
	@Deprecated
	public List<AbstractBlock> blocks() { // NOSONAR
		return abstractBlock.blocks();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#content()
	 */
	@Override
	@Deprecated
	public Object content() { // NOSONAR
		return abstractBlock.content();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#context()
	 */
	@Override
	@Deprecated
	public String context() { // NOSONAR
		return abstractBlock.context();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#convert()
	 */
	@Override
	public String convert() {
		return abstractBlock.convert();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#delegate()
	 */
	@Override
	public AbstractBlock delegate() {
		return abstractBlock.delegate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#document()
	 */
	@Override
	@Deprecated
	public DocumentRuby document() { // NOSONAR
		return abstractBlock.document();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#findBy(java.util.Map)
	 */
	@Override
	public List<AbstractBlock> findBy(Map<Object, Object> selector) {
		return abstractBlock.findBy(selector);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getAttr(java.lang.Object)
	 */
	@Override
	public Object getAttr(Object name) {
		return abstractBlock.getAttr(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getAttr(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public Object getAttr(Object name, Object defaultValue) {
		return abstractBlock.getAttr(name, defaultValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getAttr(java.lang.Object,
	 * java.lang.Object, boolean)
	 */
	@Override
	public Object getAttr(Object name, Object defaultValue, boolean inherit) {
		return abstractBlock.getAttr(name, defaultValue, inherit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getAttributes()
	 */
	@Override
	public Map<String, Object> getAttributes() {
		return abstractBlock.getAttributes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#getBlocks()
	 */
	@Override
	public List<AbstractBlock> getBlocks() {
		return abstractBlock.getBlocks();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#getContent()
	 */
	@Override
	public Object getContent() {
		return abstractBlock.getContent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getContext()
	 */
	@Override
	public String getContext() {
		return abstractBlock.getContext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getDocument()
	 */
	@Override
	public DocumentRuby getDocument() {
		return abstractBlock.getDocument();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#getLevel()
	 */
	@Override
	public int getLevel() {
		return abstractBlock.getLevel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getNodeName()
	 */
	@Override
	public String getNodeName() {
		return abstractBlock.getNodeName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getParent()
	 */
	@Override
	public AbstractNode getParent() {
		return abstractBlock.getParent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getReftext()
	 */
	@Override
	public String getReftext() {
		return abstractBlock.getReftext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getRole()
	 */
	@Override
	public String getRole() {
		return abstractBlock.getRole();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#getRoles()
	 */
	@Override
	public List<String> getRoles() {
		return abstractBlock.getRoles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#getStyle()
	 */
	@Override
	public String getStyle() {
		return abstractBlock.getStyle();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#getTitle()
	 */
	@Override
	public String getTitle() {
		return abstractBlock.getTitle();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#hasRole(java.lang.String)
	 */
	@Override
	public boolean hasRole(String role) {
		return abstractBlock.hasRole(role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#iconUri(java.lang.String)
	 */
	@Override
	public String iconUri(String name) {
		return abstractBlock.iconUri(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#id()
	 */
	@Override
	public String id() {
		return abstractBlock.id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#imageUri(java.lang.String)
	 */
	@Override
	public String imageUri(String targetImage) {
		return abstractBlock.imageUri(targetImage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#imageUri(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String imageUri(String targetImage, String assetDirKey) {
		return abstractBlock.imageUri(targetImage, assetDirKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#isAttr(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public boolean isAttr(Object name, Object expected) {
		return abstractBlock.isAttr(name, expected);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#isAttr(java.lang.Object,
	 * java.lang.Object, boolean)
	 */
	@Override
	public boolean isAttr(Object name, Object expected, boolean inherit) {
		return abstractBlock.isAttr(name, expected, inherit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#isBlock()
	 */
	@Override
	public boolean isBlock() {
		return abstractBlock.isBlock();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#isInline()
	 */
	@Override
	public boolean isInline() {
		return abstractBlock.isInline();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#isOption(java.lang.Object)
	 */
	@Override
	public boolean isOption(Object name) {
		return abstractBlock.isOption(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#isReftext()
	 */
	@Override
	public boolean isReftext() {
		return abstractBlock.isReftext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#isRole()
	 */
	@Override
	public boolean isRole() {
		return abstractBlock.isRole();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#listMarkerKeyword()
	 */
	@Override
	public String listMarkerKeyword() {
		return abstractBlock.listMarkerKeyword();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#listMarkerKeyword(java.lang.String)
	 */
	@Override
	public String listMarkerKeyword(String listType) {
		return abstractBlock.listMarkerKeyword(listType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#mediaUri(java.lang.String)
	 */
	@Override
	public String mediaUri(String target) {
		return abstractBlock.mediaUri(target);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#normalizeWebPath(java.lang.String,
	 * java.lang.String, boolean)
	 */
	@Override
	public String normalizeWebPath(String path, String start, boolean preserveUriTarget) {
		return abstractBlock.normalizeWebPath(path, start, preserveUriTarget);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#parent()
	 */
	@Override
	@Deprecated
	public AbstractNode parent() { // NOSONAR
		return abstractBlock.parent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#readAsset(java.lang.String,
	 * java.util.Map)
	 */
	@Override
	public String readAsset(String path, Map<Object, Object> opts) {
		return abstractBlock.readAsset(path, opts);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#role()
	 */
	@Override
	@Deprecated
	public String role() { // NOSONAR
		return abstractBlock.role();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractNode#setAttr(java.lang.Object,
	 * java.lang.Object, boolean)
	 */
	@Override
	public boolean setAttr(Object name, Object value, boolean overwrite) {
		return abstractBlock.setAttr(name, value, overwrite);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#style()
	 */
	@Override
	@Deprecated
	public String style() { // NOSONAR
		return abstractBlock.style();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.AbstractBlock#title()
	 */
	@Override
	@Deprecated
	public String title() { // NOSONAR
		return abstractBlock.title();
	}

	/**
	 * Content model.
	 *
	 * @return the object
	 */
	public Object content_model() { // NOSONAR
		if (contentModel != null) {
			return contentModel;
		} else {
			return ":simple";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.Block#lines()
	 */
	@Override
	public List<String> lines() {
		return abstractBlock.lines();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asciidoctor.ast.Block#source()
	 */
	@Override
	public String source() {
		return abstractBlock.source();
	}
}
