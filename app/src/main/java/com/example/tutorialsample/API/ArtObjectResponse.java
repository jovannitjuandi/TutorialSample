
package com.example.tutorialsample.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtObjectResponse {

    @SerializedName("objectID")
    @Expose
    private Integer objectID;
    @SerializedName("isHighlight")
    @Expose
    private Boolean isHighlight;
    @SerializedName("accessionNumber")
    @Expose
    private String accessionNumber;
    @SerializedName("accessionYear")
    @Expose
    private String accessionYear;
    @SerializedName("isPublicDomain")
    @Expose
    private Boolean isPublicDomain;
    @SerializedName("primaryImage")
    @Expose
    private String primaryImage;
    @SerializedName("primaryImageSmall")
    @Expose
    private String primaryImageSmall;
    @SerializedName("additionalImages")
    @Expose
    private List<Object> additionalImages = null;
    @SerializedName("constituents")
    @Expose
    private Object constituents;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("objectName")
    @Expose
    private String objectName;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("culture")
    @Expose
    private String culture;
    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("dynasty")
    @Expose
    private String dynasty;
    @SerializedName("reign")
    @Expose
    private String reign;
    @SerializedName("portfolio")
    @Expose
    private String portfolio;
    @SerializedName("artistRole")
    @Expose
    private String artistRole;
    @SerializedName("artistPrefix")
    @Expose
    private String artistPrefix;
    @SerializedName("artistDisplayName")
    @Expose
    private String artistDisplayName;
    @SerializedName("artistDisplayBio")
    @Expose
    private String artistDisplayBio;
    @SerializedName("artistSuffix")
    @Expose
    private String artistSuffix;
    @SerializedName("artistAlphaSort")
    @Expose
    private String artistAlphaSort;
    @SerializedName("artistNationality")
    @Expose
    private String artistNationality;
    @SerializedName("artistBeginDate")
    @Expose
    private String artistBeginDate;
    @SerializedName("artistEndDate")
    @Expose
    private String artistEndDate;
    @SerializedName("artistGender")
    @Expose
    private String artistGender;
    @SerializedName("artistWikidata_URL")
    @Expose
    private String artistWikidataURL;
    @SerializedName("artistULAN_URL")
    @Expose
    private String artistULANURL;
    @SerializedName("objectDate")
    @Expose
    private String objectDate;
    @SerializedName("objectBeginDate")
    @Expose
    private Integer objectBeginDate;
    @SerializedName("objectEndDate")
    @Expose
    private Integer objectEndDate;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("dimensions")
    @Expose
    private String dimensions;
    @SerializedName("measurements")
    @Expose
    private List<Measurement> measurements = null;
    @SerializedName("creditLine")
    @Expose
    private String creditLine;
    @SerializedName("geographyType")
    @Expose
    private String geographyType;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("subregion")
    @Expose
    private String subregion;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("locus")
    @Expose
    private String locus;
    @SerializedName("excavation")
    @Expose
    private String excavation;
    @SerializedName("river")
    @Expose
    private String river;
    @SerializedName("classification")
    @Expose
    private String classification;
    @SerializedName("rightsAndReproduction")
    @Expose
    private String rightsAndReproduction;
    @SerializedName("linkResource")
    @Expose
    private String linkResource;
    @SerializedName("metadataDate")
    @Expose
    private String metadataDate;
    @SerializedName("repository")
    @Expose
    private String repository;
    @SerializedName("objectURL")
    @Expose
    private String objectURL;
    @SerializedName("tags")
    @Expose
    private Object tags;
    @SerializedName("objectWikidata_URL")
    @Expose
    private String objectWikidataURL;
    @SerializedName("isTimelineWork")
    @Expose
    private Boolean isTimelineWork;
    @SerializedName("GalleryNumber")
    @Expose
    private String galleryNumber;

    public Integer getObjectID() {
        return objectID;
    }

    public void setObjectID(Integer objectID) {
        this.objectID = objectID;
    }

    public Boolean getIsHighlight() {
        return isHighlight;
    }

    public void setIsHighlight(Boolean isHighlight) {
        this.isHighlight = isHighlight;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public String getAccessionYear() {
        return accessionYear;
    }

    public void setAccessionYear(String accessionYear) {
        this.accessionYear = accessionYear;
    }

    public Boolean getIsPublicDomain() {
        return isPublicDomain;
    }

    public void setIsPublicDomain(Boolean isPublicDomain) {
        this.isPublicDomain = isPublicDomain;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    public String getPrimaryImageSmall() {
        return primaryImageSmall;
    }

    public void setPrimaryImageSmall(String primaryImageSmall) {
        this.primaryImageSmall = primaryImageSmall;
    }

    public List<Object> getAdditionalImages() {
        return additionalImages;
    }

    public void setAdditionalImages(List<Object> additionalImages) {
        this.additionalImages = additionalImages;
    }

    public Object getConstituents() {
        return constituents;
    }

    public void setConstituents(Object constituents) {
        this.constituents = constituents;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getReign() {
        return reign;
    }

    public void setReign(String reign) {
        this.reign = reign;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getArtistRole() {
        return artistRole;
    }

    public void setArtistRole(String artistRole) {
        this.artistRole = artistRole;
    }

    public String getArtistPrefix() {
        return artistPrefix;
    }

    public void setArtistPrefix(String artistPrefix) {
        this.artistPrefix = artistPrefix;
    }

    public String getArtistDisplayName() {
        return artistDisplayName;
    }

    public void setArtistDisplayName(String artistDisplayName) {
        this.artistDisplayName = artistDisplayName;
    }

    public String getArtistDisplayBio() {
        return artistDisplayBio;
    }

    public void setArtistDisplayBio(String artistDisplayBio) {
        this.artistDisplayBio = artistDisplayBio;
    }

    public String getArtistSuffix() {
        return artistSuffix;
    }

    public void setArtistSuffix(String artistSuffix) {
        this.artistSuffix = artistSuffix;
    }

    public String getArtistAlphaSort() {
        return artistAlphaSort;
    }

    public void setArtistAlphaSort(String artistAlphaSort) {
        this.artistAlphaSort = artistAlphaSort;
    }

    public String getArtistNationality() {
        return artistNationality;
    }

    public void setArtistNationality(String artistNationality) {
        this.artistNationality = artistNationality;
    }

    public String getArtistBeginDate() {
        return artistBeginDate;
    }

    public void setArtistBeginDate(String artistBeginDate) {
        this.artistBeginDate = artistBeginDate;
    }

    public String getArtistEndDate() {
        return artistEndDate;
    }

    public void setArtistEndDate(String artistEndDate) {
        this.artistEndDate = artistEndDate;
    }

    public String getArtistGender() {
        return artistGender;
    }

    public void setArtistGender(String artistGender) {
        this.artistGender = artistGender;
    }

    public String getArtistWikidataURL() {
        return artistWikidataURL;
    }

    public void setArtistWikidataURL(String artistWikidataURL) {
        this.artistWikidataURL = artistWikidataURL;
    }

    public String getArtistULANURL() {
        return artistULANURL;
    }

    public void setArtistULANURL(String artistULANURL) {
        this.artistULANURL = artistULANURL;
    }

    public String getObjectDate() {
        return objectDate;
    }

    public void setObjectDate(String objectDate) {
        this.objectDate = objectDate;
    }

    public Integer getObjectBeginDate() {
        return objectBeginDate;
    }

    public void setObjectBeginDate(Integer objectBeginDate) {
        this.objectBeginDate = objectBeginDate;
    }

    public Integer getObjectEndDate() {
        return objectEndDate;
    }

    public void setObjectEndDate(Integer objectEndDate) {
        this.objectEndDate = objectEndDate;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    public String getGeographyType() {
        return geographyType;
    }

    public void setGeographyType(String geographyType) {
        this.geographyType = geographyType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocus() {
        return locus;
    }

    public void setLocus(String locus) {
        this.locus = locus;
    }

    public String getExcavation() {
        return excavation;
    }

    public void setExcavation(String excavation) {
        this.excavation = excavation;
    }

    public String getRiver() {
        return river;
    }

    public void setRiver(String river) {
        this.river = river;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getRightsAndReproduction() {
        return rightsAndReproduction;
    }

    public void setRightsAndReproduction(String rightsAndReproduction) {
        this.rightsAndReproduction = rightsAndReproduction;
    }

    public String getLinkResource() {
        return linkResource;
    }

    public void setLinkResource(String linkResource) {
        this.linkResource = linkResource;
    }

    public String getMetadataDate() {
        return metadataDate;
    }

    public void setMetadataDate(String metadataDate) {
        this.metadataDate = metadataDate;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getObjectURL() {
        return objectURL;
    }

    public void setObjectURL(String objectURL) {
        this.objectURL = objectURL;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    public String getObjectWikidataURL() {
        return objectWikidataURL;
    }

    public void setObjectWikidataURL(String objectWikidataURL) {
        this.objectWikidataURL = objectWikidataURL;
    }

    public Boolean getIsTimelineWork() {
        return isTimelineWork;
    }

    public void setIsTimelineWork(Boolean isTimelineWork) {
        this.isTimelineWork = isTimelineWork;
    }

    public String getGalleryNumber() {
        return galleryNumber;
    }

    public void setGalleryNumber(String galleryNumber) {
        this.galleryNumber = galleryNumber;
    }

}
