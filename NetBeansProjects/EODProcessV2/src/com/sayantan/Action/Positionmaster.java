/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayantan.Action;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "positionmaster", catalog = "MarketData", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Positionmaster.findAll", query = "SELECT p FROM Positionmaster p"),
    @NamedQuery(name = "Positionmaster.findByPosid", query = "SELECT p FROM Positionmaster p WHERE p.posid = :posid"),
    @NamedQuery(name = "Positionmaster.findByStock", query = "SELECT p FROM Positionmaster p WHERE p.stock = :stock"),
    @NamedQuery(name = "Positionmaster.findByTradetype", query = "SELECT p FROM Positionmaster p WHERE p.tradetype = :tradetype"),
    @NamedQuery(name = "Positionmaster.findByAmount", query = "SELECT p FROM Positionmaster p WHERE p.amount = :amount"),
    @NamedQuery(name = "Positionmaster.findByAmountcontracts", query = "SELECT p FROM Positionmaster p WHERE p.amountcontracts = :amountcontracts"),
    @NamedQuery(name = "Positionmaster.findByStrike", query = "SELECT p FROM Positionmaster p WHERE p.strike = :strike"),
    @NamedQuery(name = "Positionmaster.findByCallput", query = "SELECT p FROM Positionmaster p WHERE p.callput = :callput"),
    @NamedQuery(name = "Positionmaster.findByPrevcloseprice", query = "SELECT p FROM Positionmaster p WHERE p.prevcloseprice = :prevcloseprice"),
    @NamedQuery(name = "Positionmaster.findByPrevcloseprem", query = "SELECT p FROM Positionmaster p WHERE p.prevcloseprem = :prevcloseprem"),
    @NamedQuery(name = "Positionmaster.findByPrevclosetheo", query = "SELECT p FROM Positionmaster p WHERE p.prevclosetheo = :prevclosetheo"),
    @NamedQuery(name = "Positionmaster.findByPrevclosevol", query = "SELECT p FROM Positionmaster p WHERE p.prevclosevol = :prevclosevol"),
    @NamedQuery(name = "Positionmaster.findByCurrentprice", query = "SELECT p FROM Positionmaster p WHERE p.currentprice = :currentprice"),
    @NamedQuery(name = "Positionmaster.findByDelta", query = "SELECT p FROM Positionmaster p WHERE p.delta = :delta"),
    @NamedQuery(name = "Positionmaster.findByGamma", query = "SELECT p FROM Positionmaster p WHERE p.gamma = :gamma"),
    @NamedQuery(name = "Positionmaster.findByVega", query = "SELECT p FROM Positionmaster p WHERE p.vega = :vega"),
    @NamedQuery(name = "Positionmaster.findByExpmatdate", query = "SELECT p FROM Positionmaster p WHERE p.expmatdate = :expmatdate"),
    @NamedQuery(name = "Positionmaster.findByCurrentprem", query = "SELECT p FROM Positionmaster p WHERE p.currentprem = :currentprem"),
    @NamedQuery(name = "Positionmaster.findByCurrentpremtheo", query = "SELECT p FROM Positionmaster p WHERE p.currentpremtheo = :currentpremtheo"),
    @NamedQuery(name = "Positionmaster.findByCurrentvol", query = "SELECT p FROM Positionmaster p WHERE p.currentvol = :currentvol")})
public class Positionmaster implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "posid")
    private String posid;
    @Column(name = "stock")
    private String stock;
    @Column(name = "tradetype")
    private String tradetype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Float amount;
    @Column(name = "amountcontracts")
    private Float amountcontracts;
    @Column(name = "strike")
    private Float strike;
    @Column(name = "callput")
    private String callput;
    @Column(name = "prevcloseprice")
    private Float prevcloseprice;
    @Column(name = "prevcloseprem")
    private Float prevcloseprem;
    @Column(name = "prevclosetheo")
    private Float prevclosetheo;
    @Column(name = "prevclosevol")
    private Float prevclosevol;
    @Column(name = "currentprice")
    private Float currentprice;
    @Column(name = "delta")
    private Float delta;
    @Column(name = "gamma")
    private Float gamma;
    @Column(name = "vega")
    private Float vega;
    @Column(name = "expmatdate")
    @Temporal(TemporalType.DATE)
    private Date expmatdate;
    @Column(name = "currentprem")
    private Float currentprem;
    @Column(name = "currentpremtheo")
    private Float currentpremtheo;
    @Column(name = "currentvol")
    private Float currentvol;

    public Positionmaster() {
    }

    public Positionmaster(String posid) {
        this.posid = posid;
    }

    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        String oldPosid = this.posid;
        this.posid = posid;
        changeSupport.firePropertyChange("posid", oldPosid, posid);
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        String oldStock = this.stock;
        this.stock = stock;
        changeSupport.firePropertyChange("stock", oldStock, stock);
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        String oldTradetype = this.tradetype;
        this.tradetype = tradetype;
        changeSupport.firePropertyChange("tradetype", oldTradetype, tradetype);
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        Float oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public Float getAmountcontracts() {
        return amountcontracts;
    }

    public void setAmountcontracts(Float amountcontracts) {
        Float oldAmountcontracts = this.amountcontracts;
        this.amountcontracts = amountcontracts;
        changeSupport.firePropertyChange("amountcontracts", oldAmountcontracts, amountcontracts);
    }

    public Float getStrike() {
        return strike;
    }

    public void setStrike(Float strike) {
        Float oldStrike = this.strike;
        this.strike = strike;
        changeSupport.firePropertyChange("strike", oldStrike, strike);
    }

    public String getCallput() {
        return callput;
    }

    public void setCallput(String callput) {
        String oldCallput = this.callput;
        this.callput = callput;
        changeSupport.firePropertyChange("callput", oldCallput, callput);
    }

    public Float getPrevcloseprice() {
        return prevcloseprice;
    }

    public void setPrevcloseprice(Float prevcloseprice) {
        Float oldPrevcloseprice = this.prevcloseprice;
        this.prevcloseprice = prevcloseprice;
        changeSupport.firePropertyChange("prevcloseprice", oldPrevcloseprice, prevcloseprice);
    }

    public Float getPrevcloseprem() {
        return prevcloseprem;
    }

    public void setPrevcloseprem(Float prevcloseprem) {
        Float oldPrevcloseprem = this.prevcloseprem;
        this.prevcloseprem = prevcloseprem;
        changeSupport.firePropertyChange("prevcloseprem", oldPrevcloseprem, prevcloseprem);
    }

    public Float getPrevclosetheo() {
        return prevclosetheo;
    }

    public void setPrevclosetheo(Float prevclosetheo) {
        Float oldPrevclosetheo = this.prevclosetheo;
        this.prevclosetheo = prevclosetheo;
        changeSupport.firePropertyChange("prevclosetheo", oldPrevclosetheo, prevclosetheo);
    }

    public Float getPrevclosevol() {
        return prevclosevol;
    }

    public void setPrevclosevol(Float prevclosevol) {
        Float oldPrevclosevol = this.prevclosevol;
        this.prevclosevol = prevclosevol;
        changeSupport.firePropertyChange("prevclosevol", oldPrevclosevol, prevclosevol);
    }

    public Float getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(Float currentprice) {
        Float oldCurrentprice = this.currentprice;
        this.currentprice = currentprice;
        changeSupport.firePropertyChange("currentprice", oldCurrentprice, currentprice);
    }

    public Float getDelta() {
        return delta;
    }

    public void setDelta(Float delta) {
        Float oldDelta = this.delta;
        this.delta = delta;
        changeSupport.firePropertyChange("delta", oldDelta, delta);
    }

    public Float getGamma() {
        return gamma;
    }

    public void setGamma(Float gamma) {
        Float oldGamma = this.gamma;
        this.gamma = gamma;
        changeSupport.firePropertyChange("gamma", oldGamma, gamma);
    }

    public Float getVega() {
        return vega;
    }

    public void setVega(Float vega) {
        Float oldVega = this.vega;
        this.vega = vega;
        changeSupport.firePropertyChange("vega", oldVega, vega);
    }

    public Date getExpmatdate() {
        return expmatdate;
    }

    public void setExpmatdate(Date expmatdate) {
        Date oldExpmatdate = this.expmatdate;
        this.expmatdate = expmatdate;
        changeSupport.firePropertyChange("expmatdate", oldExpmatdate, expmatdate);
    }

    public Float getCurrentprem() {
        return currentprem;
    }

    public void setCurrentprem(Float currentprem) {
        Float oldCurrentprem = this.currentprem;
        this.currentprem = currentprem;
        changeSupport.firePropertyChange("currentprem", oldCurrentprem, currentprem);
    }

    public Float getCurrentpremtheo() {
        return currentpremtheo;
    }

    public void setCurrentpremtheo(Float currentpremtheo) {
        Float oldCurrentpremtheo = this.currentpremtheo;
        this.currentpremtheo = currentpremtheo;
        changeSupport.firePropertyChange("currentpremtheo", oldCurrentpremtheo, currentpremtheo);
    }

    public Float getCurrentvol() {
        return currentvol;
    }

    public void setCurrentvol(Float currentvol) {
        Float oldCurrentvol = this.currentvol;
        this.currentvol = currentvol;
        changeSupport.firePropertyChange("currentvol", oldCurrentvol, currentvol);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posid != null ? posid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Positionmaster)) {
            return false;
        }
        Positionmaster other = (Positionmaster) object;
        if ((this.posid == null && other.posid != null) || (this.posid != null && !this.posid.equals(other.posid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sayantan.Action.Positionmaster[ posid=" + posid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
